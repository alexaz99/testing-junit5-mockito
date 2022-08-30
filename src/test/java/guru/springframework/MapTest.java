package guru.springframework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapTest {

    @Test
    void testHashMapAcceptNullAsKeyAndValue() {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put(null, null);
        assertEquals(hashMap.size(), 1);

        hashMap.put(null, null);
        assertEquals(hashMap.size(), 1);

        hashMap.put(null, "123");
        assertEquals(hashMap.size(), 1);

        assertEquals(hashMap.get(null), "123");
    }
}
