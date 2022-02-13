package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class VetSDJpaServiceTest {

    @Mock
    private SpecialtyRepository specialtyRepository;

    /**
     * when declare this class with @InjectMocks, instance of SpecialitySDJpaService will be
     * created and autowired with the mock object specialtyRepository
     * The same as
     * service = new SpecialitySDJpaService(specialtyRepository);
     */
    @InjectMocks
    private SpecialitySDJpaService service;

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    /**
     * verify that mocked method is called once
     */
    @Test
    void deleteById() {
        service.deleteById(5L);
        Mockito.verify(specialtyRepository).deleteById(5l);
        //Mockito.verify(specialtyRepository).deleteById(34l); // this fails because of arg 34l passed!
    }
}