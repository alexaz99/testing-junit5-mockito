package guru.springframework;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class _1_InlineMapTest {

    @Test
    void testInlineMock() {
        Map<Integer, String> mapMock = Mockito.mock(Map.class);
        assertEquals(mapMock.size(), 0);

        mapMock.put(1, "Hello");
        assertEquals(mapMock.size(), 0);

        String val = mapMock.get(Integer.valueOf(1));
        assertEquals(val, null);

        when(mapMock.size()).thenReturn(1);
        assertEquals(mapMock.size(), 1);
    }
}
