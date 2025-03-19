package be.vdab.theorie;

import org.junit.jupiter.api.Test;

import java.lang.management.BufferPoolMXBean;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StatistiekTest {
    @Test
    void hetGemiddeldeVan0En10Is5() {
        assertThat(Statistiek.getGemiddelde(new BigDecimal[]{BigDecimal.ZERO, BigDecimal.TEN})).isEqualByComparingTo("5");
    }
    @Test
    void hetGemiddeldeVanEenGetalIsDatGetal() {
        var enigGetal = BigDecimal.valueOf(1.23);
        assertThat(Statistiek.getGemiddelde(new BigDecimal[]{enigGetal})).isEqualByComparingTo(enigGetal);
    }
    @Test
    void hetGemiddeldeVanEenLegeVerzamelingKanJeNietBerekenen() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> Statistiek.getGemiddelde(new BigDecimal[]{})
        );
    }
    @Test
    void hetGemiddeldeVanNullKanJeNietBerekenen() {
        assertThatNullPointerException().isThrownBy(
                ()-> Statistiek.getGemiddelde(null)
        );
    }
    @Test
    void eenArrayElementMagNietNullBevatten() {
        assertThatNullPointerException().isThrownBy(
                ()-> Statistiek.getGemiddelde(new BigDecimal[]{null})
        );
    }
}