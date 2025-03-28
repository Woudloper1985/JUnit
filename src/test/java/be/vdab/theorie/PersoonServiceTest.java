package be.vdab.theorie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersoonServiceTest {
    @Mock
    private PersoonRepository repository;
    private PersoonService service;

    @BeforeEach
    void beforeEach() {
        service = new PersoonService(repository);
    }

//    @Test
//    void deWeddeStandaardAfwijkingIsPositief() {
//        when(repository.findAllWeddes()).thenReturn(
//                Stream.of(2, 4, 4, 4, 5, 5, 7, 9)
//                        .map(getal -> BigDecimal.valueOf(getal))
//                        .toList());
//        assertThat(service.standaardAfwijkingWeddes()).isPositive();
//    }

    @Test
    void deWeddeStandaardAfwijkingIs2() {
        when(repository.findAllWeddes()).thenReturn(
                Stream.of(2, 4, 4, 4, 5, 5, 7, 9)
                        .map(getal -> BigDecimal.valueOf(getal))
                        .toList());
        assertThat(service.standaardAfwijkingWeddes()).isEqualByComparingTo("2");
        verify(repository).findAllWeddes();
    }
}