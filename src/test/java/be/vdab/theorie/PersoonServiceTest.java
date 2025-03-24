package be.vdab.theorie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PersoonServiceTest {
    private PersoonService service;

    @BeforeEach
    void beforeEach() {
        service = new PersoonService(new PersoonRepositoryStub());
    }

    @Test
    void deWeddeStandaardAfwijkingIsPositief() {
        assertThat(service.standaardAfwijkingWeddes()).isPositive();
    }

    @Test
    void deWeddeStandaardAfwijkingIs2() {
        assertThat(service.standaardAfwijkingWeddes()).isEqualByComparingTo("2");
    }
}