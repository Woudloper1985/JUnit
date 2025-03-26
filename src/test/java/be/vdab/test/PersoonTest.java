package be.vdab.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class PersoonTest {
    private Persoon persoon;

    @BeforeEach
    void beforeEach() {
        persoon = new Persoon();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Jan", "Piet", "Abdul", "Jean-Pierre", "X Æ A-12", "L", "i", "."})
    void correcteVoornamen(String voornaam) {
        assertThatCode(() -> persoon.add(voornaam)).doesNotThrowAnyException();
        assertThat(persoon.toString().contains(voornaam)); // gezien de afwezigheid van een getter.
    }

    @ParameterizedTest
    @ValueSource(strings = {"Jan", "Piet", "Abdul", "Jean-Pierre", "X Æ A-12", "L", "i", "."})
    void dubbeleVoornamen(String voornaam) {
        persoon.add(voornaam);
        assertThatIllegalArgumentException().isThrownBy(() -> persoon.add(voornaam));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    void legeOfBlancoVoornamen(String voornaam) {
        assertThatIllegalArgumentException().isThrownBy(() -> persoon.add(voornaam));
    }

    @Test
    void nullVoornaamGeeftNullPointerException() {
        assertThatNullPointerException().isThrownBy(() -> persoon.add(null));
    }
}