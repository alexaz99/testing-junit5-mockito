package guru.springframework;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

/**
 * Use @ExtendWith(MockitoExtension.class).
 * In this case we don't need to have
 *
 * @BeforeEach
 *     void setUp() {
 *         MockitoAnnotations.initMocks(this);
 *     }
 */
@ExtendWith(MockitoExtension.class)
public class JUnitExtensionTest {

    @Mock
    Map<String, Object> mapMock;

    @Test
    void testMock() {
        mapMock.put("keyvalue", "foo");
    }
}
