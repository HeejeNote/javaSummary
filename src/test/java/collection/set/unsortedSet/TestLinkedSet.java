package collection.set.unsortedSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestLinkedSet {

    /**
     * LinkedHashSet :::
     * HashSet의 특성을 유지 + 요소의 삽입 순서를 기억
     * 중복 X / 순서 O / 정렬 X / thread-safe X / Null O
     * 빠른 검색 및 삽입 (해시 테이블을 이용한 요소 삽입) >> O(1)
     * null 요소를 한번만 허용
     * 반복 가능 (Iterable)
     * 정렬된 순서로 요소에 접근 하려면? >>> 별도로 정렬 작업을 수행 해야 함 ex) ArrayList 또는 배열에 담아서 정렬
     */

    private Set<String> linkedHashSet;

    @BeforeEach
    public void setUp(){
        //given
        linkedHashSet = new LinkedHashSet<>();
    }

    @Test
    @DisplayName("요소 추가 테스트")
    public void testAdd(){
        //when
        linkedHashSet.add("Banana");
        linkedHashSet.add("Apple");
        linkedHashSet.add("Orange");

        //then
        assertEquals(3, linkedHashSet.size());
    }

    @Test
    @DisplayName("요소 제거 테스트")
    public void testRemove(){
        //when
        linkedHashSet.add("Banana");
        linkedHashSet.add("Apple");
        linkedHashSet.add("Orange");

        //then
        assertTrue(linkedHashSet.remove("Banana"));
        assertEquals(2, linkedHashSet.size());
    }

    @Test
    @DisplayName("요소 중복 비허용 테스트")
    public void testDuplicate() {
        // when
        linkedHashSet.add("Banana");
        linkedHashSet.add("Apple");
        linkedHashSet.add("Orange");

        // then
        assertFalse(linkedHashSet.add("Apple"));

        assertEquals(3, linkedHashSet.size());
    }

    @Test
    @DisplayName("널값 허용 테스트")
    public void testNullable() {
        // when
        linkedHashSet.add("Banana");
        linkedHashSet.add("Apple");
        linkedHashSet.add("Orange");

        // then
        assertTrue(linkedHashSet.add(null));

        assertEquals(4, linkedHashSet.size());
    }
    @Test
    @DisplayName("요소 순서 유지 테스트")
    public void testOrder(){
        //when
        linkedHashSet.add("Banana");
        linkedHashSet.add("Apple");
        linkedHashSet.add(null);
        linkedHashSet.add("Orange");

        //then

        /**
         * 순회 하면서 비교
         */
        int i = 0;
        for(String lhs : linkedHashSet){
            if(i == 0){
                assertEquals("Banana", lhs);
            }else if(i == 1){
                assertEquals("Apple", lhs);
            }else if(i == 2){
                assertEquals(null, lhs);
            }else if(i == 3){
                assertEquals("Orange", lhs);
            }
            i++;
        }

        /**
         * List에 담아서 비교
         */
        List<String> expected = Arrays.asList("Banana","Apple",null,"Orange");

        List<String> actual = new ArrayList<>(linkedHashSet);

        assertEquals(expected,actual);

    }

}
