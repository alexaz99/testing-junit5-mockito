package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.repositories.VetRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * TDD
 * when => verify
 */
@ExtendWith(MockitoExtension.class)
class VetSDJpaServiceTest {

    @Mock
    VetRepository vetRepository;

    @InjectMocks
    VetSDJpaService vetSDJpaService;

    @Test
    void deleteById() {
        vetSDJpaService.deleteById(1L);

        // verify that we call vetRepository only once
        verify(vetRepository).deleteById(1L);

        // if more than one time
        vetSDJpaService.deleteById(1l);
        verify(vetRepository, times(2)).deleteById(1L);
    }
}