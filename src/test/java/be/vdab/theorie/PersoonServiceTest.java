package be.vdab.theorie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PersoonServiceTest {
    private PersoonService service;

    @BeforeEach
    void beforeEach() {
        service = new PersoonService(new PersoonRepository());
    }

    @Test
    void deWeddeStandaardAfwijkingIsPositief() {
        assertThat(service.standaardAfwijkingWeddes()).isPositive();
    }
}