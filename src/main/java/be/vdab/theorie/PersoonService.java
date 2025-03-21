package be.vdab.theorie;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class PersoonService {
    private final PersoonRepository repository;

    public PersoonService(PersoonRepository repository) {
        this.repository = repository;
    }

    BigDecimal standaardAfwijkingWeddes() {
        var weddes = repository.findAllWeddes();
        var totaal = weddes.stream()
                .reduce(BigDecimal.ZERO, (BigDecimal::add));
        var gemiddelde = totaal.divide(BigDecimal.valueOf(weddes.size()), 2, RoundingMode.HALF_UP);
        totaal = weddes.stream()
                .map(wedde -> wedde.subtract(gemiddelde))
                .map(verschil -> verschil.pow(2))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        var variantie = totaal.divide(BigDecimal.valueOf(weddes.size()), 2, RoundingMode.HALF_UP);
        var standaardAfwijking = variantie.sqrt(new MathContext(10, RoundingMode.HALF_UP));
        return standaardAfwijking;
    }
}