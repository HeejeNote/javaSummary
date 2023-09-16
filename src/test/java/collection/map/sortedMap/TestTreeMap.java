package collection.map.sortedMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

public class TestTreeMap {

    /**
     * TreeMap :::
     * key 중복 X / Value 중복 O / 순서 X / 정렬 O / thread-safe O
     * NULL key X / NULL Value O
     */

    private Map<String, String> treeMap;

    @BeforeEach
    public void setUp(){
        treeMap = new TreeMap<>();
    }

    @Test
    @DisplayName("요소 추가 테스트")
    public void testAdd() {
        // when
        treeMap.put("바나나","Banana");
        treeMap.put("사과","Apple");
        treeMap.put("오렌지","Orange");

        // then
        assertEquals(3, treeMap.size());
    }

    @Test
    @DisplayName("요소 제거 테스트")
    public void testRemove() {
        // when
        treeMap.put("바나나","Banana");
        treeMap.put("사과","Apple");
        treeMap.put("오렌지","Orange");

        treeMap.remove("바나나","Banana");

        // then

        assertEquals(2, treeMap.size());
    }

    @Test
    @DisplayName("요소 중복 테스트")
    public void testDuplicate() {
        // when
        treeMap.put("바나나","Banana");
        treeMap.put("사과","Apple");
        treeMap.put("오렌지","Orange");

        // then
        assertFalse(Boolean.parseBoolean(treeMap.put("바나나","Banana")));
    }

    @Test
    @DisplayName("요소 널값 비허용 테스트")
    public void testNullable() {
        // when
        treeMap.put("바나나","Banana");
        treeMap.put("사과","Apple");
        treeMap.put("오렌지","Orange");

        assertThrows(NullPointerException.class, () -> {
            treeMap.put(null, null);
        });

        // then

        assertEquals(3, treeMap.size());

    }
    
    @Test
    @DisplayName("요소 순서 유지 X 테스트, 정렬 테스트")
    public void testOrder() {
        // when
        treeMap.put("사과","Apple");
        treeMap.put("바나나","Banana");
        treeMap.put("오렌지","Orange");

        StringBuilder order = new StringBuilder();
        for(Map.Entry<String,String> entry : treeMap.entrySet()){
            order.append(entry.getKey()).append(" ");
        }

        // then

        String result = order.toString().trim();
        String expect = "사과 바나나 오렌지";

        assertFalse(result.equals(expect), "테스트 실패시 ::: 순서가 같습니다.");

    }
}
