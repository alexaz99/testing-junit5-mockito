package guru.springframework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

/**
 * 2-step process
 *  1. declare mock with annotation
 *  2. initialize in setUp method
 */
public class AnnotationMockTest {

    // declare as an instance
    @Mock
    Map<String, Object> mapMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAnnotationMock() {
        Assertions.assertEquals(mapMock.size(), 0);
        mapMock.put("keyVal", "Foo");
    }
}
