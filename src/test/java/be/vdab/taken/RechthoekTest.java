package be.vdab.taken;

import be.vdab.theorie.Jaar;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RechthoekTest {

    @Test
    void deOppervlakteVanEenRechtHoekVan5Op3Is15() {
        assertThat(new Rechthoek(5, 3).getOppervlakte()).isEqualTo(15);
    }

    @Test
    void deOmtrekVanEenRechtHoekVan5Op3Is16() {
        assertThat(new Rechthoek(5, 3).getOmtrek()).isEqualTo(16);
    }

    @Test
    void rechthoekenMetDezelfdeLengteEnBreedteZijnGelijk() {
        assertThat(new Rechthoek(5,3)).isEqualTo(new Rechthoek(5,3));
    }

    @Test
    void rechthoekenMetVerschillendeLengteEnBreedteZijnVerschillend() {
        assertThat(new Rechthoek(5,3)).isNotEqualTo(new Rechthoek(4,2));
    }

    @Test
    void deHashCodeVanGelijkeRechthoekenIsGelijk() {
        assertThat(new Rechthoek(5,3)).hasSameHashCodeAs(new Rechthoek(5,3));
    }
}
