package guru.springframework;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Use Mockito.mock to create a mock object.
 */
public class InlineMockTest {

    @Test
    void testInlineMock() {
        Map mapMock = mock(Map.class);
        assertEquals(mapMock.size(), 0);
    }
}
