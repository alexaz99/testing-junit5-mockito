package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceBTTTest {

    @Mock
    private VisitRepository visitRepository;

    @InjectMocks
    VisitSDJpaService service;

    @DisplayName("Test Find All")
    @Test
    void findAll() {

        // given
        Visit visit = new Visit();
        Set<Visit> visits = new HashSet<>();
        visits.add(visit);
        given(visitRepository.findAll()).willReturn(visits);

        // when
        Set<Visit> foundVisits = service.findAll();

        // then
        assertEquals(1, foundVisits.size());
        then(visitRepository).should().findAll();
    }

    @DisplayName("Test Find By Id")
    @Test
    void findById() {

        // given
        Visit visit = new Visit();
        given(visitRepository.findById(anyLong())).willReturn(Optional.of(visit));

        // when
        Visit foundVisit = service.findById(anyLong());

        // then
        assertNotNull(foundVisit);
        then(visitRepository).should().findById(anyLong());
    }

    @DisplayName("Test Save")
    @Test
    void save() {
        // given
        Visit visit = new Visit();
        given(visitRepository.save(any(Visit.class))).willReturn(visit);

        // when
        Visit returnVisit = service.save(visit);

        // then
        assertNotNull(returnVisit);
        then(visitRepository).should().save(any(Visit.class));
    }

    @DisplayName("Test Delete")
    @Test
    void delete() {
        // given
        Visit visit = new Visit();

        // when
        service.delete(visit);

        // then
        then(visitRepository).should().delete(any(Visit.class));
    }

    @DisplayName("Test Delete By Id")
    @Test
    void deleteById() {
        // given - none

        // when
        service.deleteById(1L);

        // then
        then(visitRepository).should().deleteById(anyLong());
    }
}