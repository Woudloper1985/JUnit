package be.vdab.taken;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

//De method telWoorden telt het aantal woorden in een zin.
//Woorden worden van elkaar gescheiden door één of meerdere spaties en/of komma’s.
class WoordTellerTest {
    private WoordTeller woordTeller;

    @BeforeEach
    void beforeEach() {
        woordTeller = new WoordTeller();
    }

    @Test
    void eenNullWaardeKanNiet() {
        assertThatNullPointerException().isThrownBy(
                () -> woordTeller.telWoorden(null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "     ", ",", ",,,", " ,  , ,,"})
    void bevat0Woorden(String tekst) {
        assertThat(woordTeller.telWoorden(tekst)).isZero();
    }


}