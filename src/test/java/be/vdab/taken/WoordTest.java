package be.vdab.taken;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WoordTest {
    @Test
    void eenWoordDatHetzelfdeIsVanVoorNaarAchterIsEenPalindroom() {
        var woord = new Woord("lepel");
        assertThat(woord.isPalindroom()).isTrue();
    }

    @Test
    void eenWoordDatNietHetzelfdeIsVanVoorNaarAchterIsGeenPalindroom() {
        var woord = new Woord("stoel");
        assertThat(woord.isPalindroom()).isFalse();
    }

    @Test
    void eenLegeStringIsEenPalindroom() {
        assertThat(new Woord("").isPalindroom()).isTrue();
    }
}
