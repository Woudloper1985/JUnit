package be.vdab.taken;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class WoonplaatsServiceTest {
    private WoonplaatsService service;

    @BeforeEach
    void beforeEach(){
        service = new WoonplaatsService(new WoonplaatsRepositoryStub());
    }

    @Test
        void hetMaximumAantalStreepjesIsGroterOfGelijkAanNul() {
            assertThat(service.maxAantalStreepjesInEenWoonplaats()).isGreaterThanOrEqualTo(0);
            //bij .isNotNegative mag 0 (impliciet) ook, dus die method mag ook
        // (.isPositive is strikt positief, dus 0 niet incluis!)
    }

    @Test
    void hetMaxAantalStreepjesIsTwee() {
        assertThat(service.maxAantalStreepjesInEenWoonplaats()).isEqualTo(3);
    }
}