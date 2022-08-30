package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.repositories.VetRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class VetSDJpaServiceTest {

    @Mock
    VetRepository vetRepository;

    /** This is a service into which we inject the mock object to test. */
    @InjectMocks
    VetSDJpaService service;

    /** Mock vetRepository is under the test. */
    @Test
    void deleteById() {
        service.deleteById(1L);

        verify(vetRepository).deleteById(1L);
    }
}