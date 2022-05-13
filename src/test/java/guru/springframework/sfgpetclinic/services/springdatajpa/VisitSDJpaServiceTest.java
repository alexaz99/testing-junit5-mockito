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

import static org.assertj.core.api.Assertions.assertThat;

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

        // when. Specify what we return from a Mock object call
        // 1. create a condition what to return when mocked object
        // visitRepository findAll method is called
        when(visitRepository.findAll()).thenReturn(visits); // need to set when method return something

        // 2. Execute the service method and it should return the visits object from when
        Set<Visit> foundVisits = visitSDJpaService.findAll();

        // 3. Should return 1 item in the collection
        assertTrue(foundVisits.size() == 1);
        assertThat(foundVisits).isNotNull(); // use assertj API

        // 4. Validate that visitRepository.findAll() was called once
        verify(visitRepository).findAll();
    }

    @Test
    void findById() {
        Visit visit = new Visit();
        when(visitRepository.findById(anyLong())).thenReturn(Optional.of(visit)); // need to set when method return something
        Visit foundVisit = visitSDJpaService.findById(1L);
        assertNotNull(foundVisit);
        assertThat(foundVisit).isNotNull(); // use assertj API
        verify(visitRepository).findById(anyLong());
    }

    @Test
    void save() {
        Visit visit = new Visit();
        when(visitRepository.save(any(Visit.class))).thenReturn(visit); // need to set when method return something
        Visit savedVisit = visitSDJpaService.save(visit);
        assertNotNull(savedVisit);
        assertThat(savedVisit).isNotNull(); // use assertj API
        verify(visitRepository).save(any(Visit.class)); // make sure we call once
    }

    @Test
    void delete() {
        Visit visit = new Visit();
        visitSDJpaService.delete(visit);
        verify(visitRepository).delete(any(Visit.class));
    }

    @Test
    void deleteById() {
        visitSDJpaService.deleteById(1L);
        verify(visitRepository).deleteById(anyLong());
    }
}