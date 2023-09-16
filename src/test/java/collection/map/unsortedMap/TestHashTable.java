package collection.map.unsortedMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;

import static org.junit.jupiter.api.Assertions.*;

public class TestHashTable {

    /**
     * HashTable :::
     * key 중복 X / Value 중복 O / 순서 X / 정렬 x / thread-safe O
     * NULL key X / NULL Value X
     */

    private Map<String, String> hashTable;

    @BeforeEach
    public void setUp(){
        // Given
        hashTable = new Hashtable<>();
    }

    @Test
    @DisplayName("요소 추가 테스트")
    public void testAdd() {
        // when
        hashTable.put("바나나","Banana");
        hashTable.put("사과","Apple");
        hashTable.put("오렌지","Orange");

        // then
        assertEquals(3, hashTable.size());
    }

    @Test
    @DisplayName("요소 제거 테스트")
    public void testRemove() {
        // when
        hashTable.put("바나나","Banana");
        hashTable.put("사과","Apple");
        hashTable.put("오렌지","Orange");

        // then
        assertTrue(hashTable.remove("바나나","Banana"));

        assertEquals(2, hashTable.size());
    }

    @Test
    @DisplayName("요소 중복 테스트")
    public void testDuplicate() {
        // when
        hashTable.put("바나나","Banana");
        hashTable.put("사과","Apple");
        hashTable.put("오렌지","Orange");

        // then
        assertFalse(Boolean.parseBoolean(hashTable.put("바나나","Banana")));

        assertEquals(3, hashTable.size());
    }

    @Test
    @DisplayName("요소 널값 비허용 테스트")
    public void testNullable() {
        // when
        hashTable.put("바나나","Banana");
        hashTable.put("사과","Apple");
        hashTable.put("오렌지","Orange");

        assertThrows(NullPointerException.class, () -> {
            //when
            hashTable.put(null,null); // null 요소를 추가 > 예외 발생
        });

        // then

        assertEquals(3, hashTable.size());
    }

    @Test
    @DisplayName("요소 순서 유지 X 테스트")
    public void testOrder() {
        // when
        hashTable.put("사과","Apple");
        hashTable.put("바나나","Banana");
        hashTable.put("오렌지","Orange");

        StringBuilder order = new StringBuilder();
        for(Entry<String, String> entry : hashTable.entrySet()){
            order.append(entry.getKey()).append(" ");
        }

        // then
        String result = order.toString().trim();
        String expect = "사과 바나나 오렌지";

        assertFalse(result.equals(expect), "테스트 실패시 ::: 순서가 같습니다.");

    }
}
