package collection.map.unsortedMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TestLinkedHashMap {

    /**
     * LinkedHashMap :::
     * key 중복 X / Value 중복 O / 순서 O / 정렬 x / thread-safe X
     * NULL key O / NULL Value O
     */

    private Map<String,String> linkedHashMap;

    @BeforeEach
    public void setUp(){
        //given
        linkedHashMap = new LinkedHashMap<>();
    }

    @Test
    @DisplayName("요소 추가 테스트")
    public void testAdd() {
        // when
        linkedHashMap.put("바나나","Banana");
        linkedHashMap.put("사과","Apple");
        linkedHashMap.put("오렌지","Orange");

        // then
        assertEquals(3,linkedHashMap.size());
    }

    @Test
    @DisplayName("요소 제거 테스트")
    public void testRemove() {
        // when
        linkedHashMap.put("바나나","Banana");
        linkedHashMap.put("사과","Apple");
        linkedHashMap.put("오렌지","Orange");

        // then
        assertTrue(linkedHashMap.remove("바나나","Banana"));

        assertEquals(2, linkedHashMap.size());
    }

    @Test
    @DisplayName("요소 중복 테스트")
    public void testDuplicate() {
        // when
        linkedHashMap.put("바나나","Banana");
        linkedHashMap.put("사과","Apple");
        linkedHashMap.put("오렌지","Orange");

        // then
        assertFalse(Boolean.parseBoolean(linkedHashMap.put("바나나","Banana")));

        assertEquals(3, linkedHashMap.size());
    }

    @Test
    @DisplayName("요소 널값 허용 테스트")
    public void testNullable() {
        // when
        linkedHashMap.put("바나나","Banana");
        linkedHashMap.put("사과","Apple");
        linkedHashMap.put("오렌지","Orange");

        // then

        assertNull(linkedHashMap.put(null,null));

        assertEquals(4, linkedHashMap.size());
    }

    @Test
    @DisplayName("요소 순서 테스트")
    public void testOrder() {
        // when
        linkedHashMap.put("바나나","Banana");
        linkedHashMap.put("사과","Apple");
        linkedHashMap.put("오렌지","Orange");

        StringBuilder order = new StringBuilder();
        for(Map.Entry<String, String> entry : linkedHashMap.entrySet()){
            order.append(entry.getKey()).append(" ");
        }

        // then
        String result = order.toString().trim();
        String expect = "바나나 사과 오렌지";

        assertEquals(expect, result, "테스트 실패시 ::: 순서가 다릅니다.");
    }

}
