package be.vdab.theorie;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("/Users/Nick/data/personen.csv");
        System.out.println(Files.exists(path));
        System.out.println(Files.isReadable(path));
    }
}