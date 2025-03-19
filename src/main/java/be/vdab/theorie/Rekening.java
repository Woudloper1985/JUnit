package be.vdab.theorie;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Rekening {
    private final List<BigDecimal> stortingen = new ArrayList<>();

    void stort(BigDecimal bedrag) {
        if (bedrag.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Bedrag moet positief zijn");
        }
        stortingen.add(bedrag);
    }

    BigDecimal getSaldo() {
        return stortingen.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    List<BigDecimal> getStortingen() {
        return stortingen;
    }

    List<BigDecimal> getStortingenGesorteerd() {
        return stortingen.stream().sorted().toList();
    }
}