package be.vdab.taken;

import java.time.LocalDate;

class Periode {
    private final LocalDate van;
    private final LocalDate tot;

    Periode(LocalDate van, LocalDate tot) {
        if (tot.isBefore(van)) {
            throw new IllegalArgumentException();
        }
        this.van = van;
        this.tot = tot;
    }

    boolean komtNa(Periode periode) {
        return van.isAfter(periode.tot);
    }

//    boolean overlaptMet(Periode periode) {
//        return tot.compareTo(periode.van) >= 0 &&
//                van.compareTo(periode.tot) <= 0;
//    }

    boolean overlaptMet(Periode periode) {
        return !(van.isAfter(periode.tot) || tot.isBefore(periode.van));
        // indien de start van deze periode valt na het einde van de periode in het argument
        // OF indien het einde van deze periode valt voor het begin van de periode in het argument
        // dan is er GEEN overlap. De inverse hiervan (!) is WEL overlap.
    }

}