package be.vdab.taken;

import java.math.BigDecimal;

public class Veiling {
    private BigDecimal hoogsteBod = BigDecimal.ZERO;

    void doeBod(BigDecimal bedrag) {
        if (bedrag.compareTo(hoogsteBod) > 0) {
            hoogsteBod = bedrag;
        }
    }

    public BigDecimal getHoogsteBod() {
        return hoogsteBod;
    }
}
