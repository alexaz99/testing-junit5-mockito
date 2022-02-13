package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {

    @Mock
    private VisitRepository visitRepository;

    @InjectMocks
    VisitSDJpaService service;

    @Test
    void findAll() {
        Visit visit = new Visit();
        Set<Visit> visits = new HashSet<>();
        visits.add(visit);

        when(visitRepository.findAll()).thenReturn(visits);

        Set<Visit> foundVisits = service.findAll();

        assertEquals(1, foundVisits.size());

        verify(visitRepository).findAll(); // call only once
    }

    @Test
    void findById() {
        Visit visit = new Visit();

        //when(visitRepository.findById(1L)).thenReturn(Optional.of(visit));
        when(visitRepository.findById(anyLong())).thenReturn(Optional.of(visit));

        //Visit foundVisit = service.findById(1L);
        Visit foundVisit = service.findById(anyLong());

        assertNotNull(foundVisit);

        // verify that we called findById only once
        verify(visitRepository).findById(anyLong());
    }

    @Test
    void save() {
        Visit visit = new Visit();

        when(visitRepository.save(any(Visit.class))).thenReturn(visit);

        Visit returnVisit = service.save(visit);
        //Visit returnVisit = service.save(any(Visit.class));

        assertNotNull(returnVisit);

        // verify that we called findById only once
        verify(visitRepository).save(any(Visit.class));
    }

    @Test
    void delete() {
        Visit visit = new Visit();
        service.delete(visit);
        verify(visitRepository).delete(any(Visit.class));
    }

    @Test
    void deleteById() {
        //service.deleteById(anyLong());
        service.deleteById(1L);

        verify(visitRepository).deleteById(anyLong());
    }
}