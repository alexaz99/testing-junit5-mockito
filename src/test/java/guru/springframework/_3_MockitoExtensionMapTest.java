package guru.springframework;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * This MockitoExtension extension class does the same job as
 * @BeforeEach void setUp() method in AnnotationMapTest class
 *
 * Only one object can be under the test and we assert againt it.
 * This is a mock object. All others object helps us to run the test.
 * They are stubs. This is the basic idea!
 * Everything is fake unless you use it as the Mock.
 */
@ExtendWith(MockitoExtension.class)
public class _3_MockitoExtensionMapTest {

    @Mock
    Map<Integer, String> mapMock;

    @Mock
    List<Long> mockList;

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

    @Test
    void shouldCallListOnce() {
        // 1. verify that we call add method on the Mock object only once.
        mockList.add(new Random().nextLong());
        verify(mockList).add(anyLong());

        // a simple test to return some value from a List and assert that it's correct one.
        when(mockList.get(anyInt())).thenReturn(5L);

        long val = mockList.get(1);
        assertEquals(val, 5);

        verify(mockList).get(anyInt());

    }
}
