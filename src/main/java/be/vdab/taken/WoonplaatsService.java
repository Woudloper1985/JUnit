package be.vdab.taken;

public class WoonplaatsService {
    private final TxtWoonplaatsRepository repository;

    public WoonplaatsService(TxtWoonplaatsRepository repository) {
        this.repository = repository;
    }

    long maxAantalStreepjesInEenWoonplaats() {
        return repository.findMetStreepjes()
                .stream()
                .mapToLong(woonplaats -> woonplaats.length() - woonplaats.replace("-", "").length())
                .max()
                .orElse(0);
    } //iets andere oplossing in de cursus, maar deze is zeker even correct en kort.
}