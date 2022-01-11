package guru.springframework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Map;

public class InLineMockTest {

    @Test
    void testInlineMock() {
        Map mapMock = Mockito.mock(Map.class);
        Assertions.assertEquals(mapMock.size(), 0);
    }
}
