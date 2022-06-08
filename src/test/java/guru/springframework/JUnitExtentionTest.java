package guru.springframework;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class JUnitExtentionTest {

    @Mock
    Map<String, Object> mapMock;

    @Test
    void testMock() {
        //mapMock.put("key", "foo");
        assertEquals(mapMock.size(), 0);

        when(mapMock.size()).thenReturn(4);
        assertEquals(mapMock.size(), 4);

        verify(mapMock, times(2)).size();
    }
}
