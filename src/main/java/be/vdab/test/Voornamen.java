package be.vdab.test;
//test 3
class Voornamen { // Productieklasse is niet nodig; is meer als extra oefening voor mezelf.
    public static void main(String[] args) {
        Persoon persoon = new Persoon();

        try {
            persoon.add("Jan");
            persoon.add("Piet-Joris.!  ");
            persoon.add("  Abdul");
            System.out.println("Voornamen: " + persoon);
            persoon.add("Jan"); // Test dubbele naam
        } catch (IllegalArgumentException ex) {
            System.err.println("Fout: " + ex.getMessage());
        }

        try {
            persoon.add(""); // Test blanco naam
        } catch (IllegalArgumentException ex) {
            System.err.println("Fout: " + ex.getMessage());
        }

        try {
            persoon.add(" "); // Test blanco naam met spaties
        } catch (IllegalArgumentException ex) {
            System.err.println("Fout: " + ex.getMessage());
        }

        try {
            persoon.add(null); // Test lege naam (met null-waarde)
        } catch (NullPointerException ex) {
            System.err.println("Fout: " + ex.getMessage());
        }

        System.out.println("Eindresultaat: " + persoon);
    }
}