package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// run this test using MockitoExtension class
@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {

    @Mock
    private VisitRepository visitRepository;

    @InjectMocks
    VisitSDJpaService visitSDJpaService;

    @Test
    void findAll() {
        Visit visit = new Visit();
        Set<Visit> visits = new HashSet<>();
        visits.add(visit);

        // 1. create a condition what to return when mocked object
        // visitRepository findAll method is called
        when(visitRepository.findAll()).thenReturn(visits);

        // 2. Execute the service method
        Set<Visit> foundVisits = visitSDJpaService.findAll();

        // 3. Should return 1 item in the collection
        assertTrue(foundVisits.size() == 1);

        //assertTh

        // 4. Validate that visitRepository.findAll() was called once
        verify(visitRepository).findAll();
    }

    @Test
    void findById() {
        Visit visit = new Visit();
        when(visitRepository.findById(anyLong())).thenReturn(Optional.of(visit));
        Visit foundVisit = visitSDJpaService.findById(1L);
        assertNotNull(foundVisit);
        verify(visitRepository).findById(anyLong());
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}