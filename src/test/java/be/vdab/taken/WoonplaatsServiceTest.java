package be.vdab.taken;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WoonplaatsServiceTest {
    @Mock
    private WoonplaatsRepository repository;
    private WoonplaatsService service;

    @BeforeEach
    void beforeEach() {
        service = new WoonplaatsService(repository);
    }

//    @Test
//    void hetMaximumAantalStreepjesIsGroterOfGelijkAanNul() {
//        assertThat(service.maxAantalStreepjesInEenWoonplaats()).isGreaterThanOrEqualTo(0);
//        //bij .isNotNegative mag 0 (impliciet) ook, dus die method mag ook
//        // (.isPositive is strikt positief, dus 0 niet incluis!)
//    }

    @Test
    void hetMaxAantalStreepjesIs3() {
        when(repository.findMetStreepjes()).thenReturn(
                Stream.of("Oost-Rozebeke", "Hoegarre", "Sjakkemakke", "Van-Ranst-In't-Goor")
                        .toList());
        assertThat(service.maxAantalStreepjesInEenWoonplaats()).isEqualTo(3);
        verify(repository).findMetStreepjes();
    }
}