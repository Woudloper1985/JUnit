package be.vdab.test;

import java.util.LinkedHashSet;

class Persoon {
    private final LinkedHashSet<String> voornamen = new LinkedHashSet<>();

    public void add(String voornaam) {
//        throw new UnsupportedOperationException();
        if (voornaam == null) {
            throw new NullPointerException("Voornaam mag niet leeg zijn; je moet iets invullen.");
        }
        if (voornaam.isBlank()) {
            throw new IllegalArgumentException("Voornaam moet minstens één niet-blanco teken bevatten.");
        }
        if (voornamen.contains(voornaam)) {
            throw new IllegalArgumentException("Voornaam " + voornaam + " komt al voor in de voornamen.");
        }
        voornamen.add(voornaam);
    }

    @Override
    public String toString() {
//        throw new UnsupportedOperationException();
        return String.join(" ", voornamen);
    }
}
