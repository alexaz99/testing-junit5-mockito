package guru.springframework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Use Annotation to create a mock object.
 */
public class AnnotationMocksTest {

    @Mock
    Map<String, Object> mapMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testMock() {
        mapMock.put("keyvalue", "foo");

        when(mapMock.get("keyvalue")).thenReturn("foo");
        when(mapMock.size()).thenReturn(1);

        assertEquals("foo", mapMock.get("keyvalue"));
        assertEquals(1, mapMock.size());
    }
}
