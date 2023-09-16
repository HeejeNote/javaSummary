package collection.map.unsortedMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TestHashMap {

    /**
     * HashMap :::
     * key / value 형태
     * key 중복 X / Value 중복 O / 순서 X / 정렬 X
     * NULL key O / NULL Value O
     */

    private Map<String, String> hashMap;

    @BeforeEach
    public void setUp() {
        // given
          hashMap = new HashMap<>();
    }

    @Test
    @DisplayName("요소 추가 테스트")
    public void testAdd() {
        // when
        hashMap.put("바나나","Banana");
        hashMap.put("사과","Apple");
        hashMap.put("오렌지","Orange");

        // then
        assertEquals(3, hashMap.size());
    }

    @Test
    @DisplayName("요소 제거 테스트")
    public void testRemove() {
        // when
        hashMap.put("바나나","Banana");
        hashMap.put("사과","Apple");
        hashMap.put("오렌지","Orange");

        // then
        assertTrue(hashMap.remove("바나나","Banana"));

        assertEquals(2,hashMap.size());
    }

    @Test
    @DisplayName("요소 중복 비허용 테스트")
    public void testDuplicate(){
        // When
        hashMap.put("바나나","Banana");
        hashMap.put("사과","Apple");
        hashMap.put("오렌지","Orange");

        // Then
        assertFalse(Boolean.parseBoolean(hashMap.put("바나나","Bananas")));

        assertEquals(3, hashMap.size());
    }


    @Test
    @DisplayName("요소 널값 허용 테스트")
    public void tellNullable() {
        // when
        hashMap.put("바나나","Banana");
        hashMap.put("사과","Apple");
        hashMap.put("오렌지","Orange");

        // then
        // assertTrue로 put을 하게 되면 Null 값이 key에 연결되지 않은 상태이므로 false가 발생
//        assertTrue(Boolean.parseBoolean(hashMap.put(null,null)));
        assertNull(hashMap.put(null,null)); // null 반환
        assertEquals(4, hashMap.size()); // null이 key 연결되었으므로 size는 4
    }


}
