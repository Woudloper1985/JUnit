package be.vdab.taken;

import be.vdab.theorie.*;

import java.util.Scanner;

public class MaxAantalStreepjes {
    public static void main(String[] args) {
        System.out.println("1=woonplaatsen.txt, 2=database:");
        var scanner = new Scanner(System.in);
        var keuze = scanner.nextInt();
        while (keuze != 1 && keuze != 2) {
            System.out.println("Verkeerde keuze, probeer opnieuw:");
            keuze = scanner.nextInt();
        }
        WoonplaatsRepository repository =
                keuze == 1 ?
                        new TxtWoonplaatsRepository() :
                        new JdbcWoonplaatsRepository();
        var service = new WoonplaatsService(repository);
        try {
            System.out.println(service.maxAantalStreepjesInEenWoonplaats());
        } catch (RepositoryException ex) {
            System.err.println("Kan woonplaatsen niet lezen.");
            ex.printStackTrace(System.err);
        }
    }
}