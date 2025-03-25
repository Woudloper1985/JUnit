package be.vdab.theorie;

import java.util.Scanner;

public class StandaardAfwijking {
    public static void main(String[] args) {
        System.out.println("1=personen.csv, 2=database:");
        var scanner = new Scanner(System.in);
        var keuze = scanner.nextInt();
        while (keuze != 1 && keuze != 2) {
            System.out.println("Verkeerde keuze, probeer opnieuw:");
            keuze = scanner.nextInt();
        }
        PersoonRepository repository =
                keuze == 1 ?
                        new CsvPersoonRepository() :
                        new JdbcPersoonRepository();
        var service = new PersoonService(repository);
        try {
            System.out.println(service.standaardAfwijkingWeddes());
        } catch (RepositoryException ex) {
            System.err.println("Kan personen niet lezen.");
            ex.printStackTrace(System.err);
        }
    }
}
