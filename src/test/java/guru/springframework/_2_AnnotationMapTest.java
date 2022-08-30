package guru.springframework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class _2_AnnotationMapTest {

    @Mock
    Map<Integer, String> mapMock;

    /**
     * Need to run before eachmethod to init all annotated mocks
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testMock() {
        assertEquals(mapMock.size(), 0);

        mapMock.put(1, "Hello");
        assertEquals(mapMock.size(), 0);

        String val = mapMock.get(Integer.valueOf(1));
        assertEquals(val, null);

        when(mapMock.size()).thenReturn(1);
        assertEquals(mapMock.size(), 1);

        // verify that we called 3 times
        verify(mapMock, times(3)).size();
    }
}
