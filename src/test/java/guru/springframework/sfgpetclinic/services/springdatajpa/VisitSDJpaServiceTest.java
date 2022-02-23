package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
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
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {

    @Mock
    private VisitRepository visitRepository;

    @InjectMocks
    VisitSDJpaService service;

    @DisplayName("Test Find All")
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

    @DisplayName("Test Find By Id")
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

    @DisplayName("Test Save")
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

    @DisplayName("Test Delete")
    @Test
    void delete() {
        Visit visit = new Visit();
        service.delete(visit);
        verify(visitRepository).delete(any(Visit.class));
    }

    @DisplayName("Test Delete By Id")
    @Test
    void deleteById() {
        //service.deleteById(anyLong());
        service.deleteById(1L);

        verify(visitRepository).deleteById(anyLong());
    }

    @Test
    void testDoThrow() {
        doThrow(new RuntimeException("bum")).when(visitRepository).delete(any(Visit.class));

        // detect that the exception was actually thrown
        assertThrows(RuntimeException.class, () -> visitRepository.delete(new Visit()));

        // check that the method visitRepository.delete was called once.
        verify(visitRepository).delete(any());
    }

    // BTT style
    @Test
    void testByIDThrows() {

        // given
        given(visitRepository.findById(1L)).willThrow(new RuntimeException("boom"));

        assertThrows(RuntimeException.class, () -> service.findById(1L));

        // then
        then(visitRepository).should().findById(1L);
    }

    // BTT style when verified call does not return anything like delete.
    @Test
    void testDeleteBDDThrows() {
        willThrow(new RuntimeException("boom")).given(visitRepository).delete(any());

        assertThrows(RuntimeException.class, () -> visitRepository.delete(new Visit()));

        then(visitRepository).should().delete(any());
    }
}