package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import guru.springframework.sfgpetclinic.repositories.VetRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class VetSDJpaServiceTest {

    // This mock object is under the test.
    // Only one Mock object should be under the test.
    @Mock
    private VetRepository vetRepository;

    /**
     * when declare this class with @InjectMocks, instance of SpecialitySDJpaService will be
     * created and autowired with the mock object specialtyRepository
     * The same as
     * service = new SpecialitySDJpaService(specialtyRepository);
     */
    @InjectMocks
    private VetSDJpaService service;

    @Test
    void findAll() {
    }

    @Test
    void findById() {
        //Vet vet = new Vet();

/*        service.findById(Mockito.anyLong());
        service.findById(Mockito.anyLong());
        service.findById(Mockito.anyLong());*/

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

        // verify that we call deleteById with parameter 5L just once.
        Mockito.verify(vetRepository).deleteById(5l);
    }
}