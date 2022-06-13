package guru.springframework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by jt on 2018-10-29.
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

        // verify that we call mapMock.put method only once. It's default in verify.
        verify(mapMock).put(anyString(), anyString());

        mapMock.put("keyvalue2", "foo2");
        mapMock.put("keyvalue3", "foo3");

        // now verify that we call mapMock.put method 3 times
        verify(mapMock, times(3)).put(anyString(), anyString());
    }
}
