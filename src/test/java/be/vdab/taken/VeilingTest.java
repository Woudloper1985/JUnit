package be.vdab.taken;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class VeilingTest {
    private Veiling veiling;

    @BeforeEach
    void beforeEach() {
        veiling = new Veiling();
    }

    @Test
    void hetHoogsteBodVanEenNieuweVeilingIs0€() {
        assertThat(veiling.getHoogsteBod()).isZero();
    }

    @Test
    void naEenBodVan1000€IsHetHoogsteBod1000€() {
        veiling.doeBod(BigDecimal.valueOf(1000));
        assertThat(veiling.getHoogsteBod()).isEqualByComparingTo("1000");
    }

    @Test
    void naEenBodVan2000€IsHetHoogsteBod2000€() {
        veiling.doeBod(BigDecimal.valueOf(1000));
        veiling.doeBod(BigDecimal.valueOf(2000));
        veiling.doeBod(BigDecimal.valueOf(1000));
        assertThat(veiling.getHoogsteBod()).isEqualByComparingTo("2000");
    }
}