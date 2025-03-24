package be.vdab.taken;

import java.util.List;
import java.util.stream.Stream;

public class WoonplaatsRepositoryStub extends WoonplaatsRepository{
    @Override
    List<String> findMetStreepjes() {
        return Stream.of("Oost-Rozebeke", "Hoegarre", "Sjakkemakke", "Van-Ranst-In't-Goor")
                .toList();
    }
}
