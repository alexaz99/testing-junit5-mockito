package guru.springframework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.*;


@ExtendWith(MockitoExtension.class)
public class ThrowExceptionTest {

    @Mock
    IThrowException throwExceptionInterface;

    @Test
    void testRetrieveThrow() {
        Mockito.doThrow(new RuntimeException()).when(throwExceptionInterface).retrieve();
        Assertions.assertThrows(RuntimeException.class, () -> throwExceptionInterface.retrieve());
        Mockito.verify(throwExceptionInterface).retrieve();
    }

    @Test
    void testRetrieveThrowBDD() {
        willThrow(new RuntimeException("Boom")).given(throwExceptionInterface).retrieve();
        Assertions.assertThrows(RuntimeException.class, () -> throwExceptionInterface.retrieve());
        then(throwExceptionInterface).should().findById(1L);
    }

    @Test
    void testFindByIdBDD() {
        // BDD works only for return value
        // given
        given(throwExceptionInterface.findById(1L)).willThrow(new RuntimeException("Boom"));

        //when
        Assertions.assertThrows(RuntimeException.class, () -> throwExceptionInterface.findById(1L));

        // then
        then(throwExceptionInterface).should().findById(1L);
    }
}
