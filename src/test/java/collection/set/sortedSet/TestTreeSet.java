package collection.set.sortedSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestTreeSet {
    /**
     * TreeSet :::
     * 이진 검색 트리를 이용한 Set
     * 중복 X / 순서 X / 정렬 O / thread-safe X / Null X
     * 요소를 정렬된 순서로 저장 O(log N)
     * Null 허용 하지 않음
     * 요소에 대한 자동 정렬이 지원된다.
     */

    private Set<String> treeSet;

    @BeforeEach
    public void setUp(){
        //given
        treeSet = new TreeSet<>();
    }

    @Test
    @DisplayName("요소 추가 테스트")
    public void testAdd(){
        //when
        treeSet.add("Banana");
        treeSet.add("Apple");
        treeSet.add("Orange");

        //then
        assertEquals(3,treeSet.size());

    }

    @Test
    @DisplayName("요소 제거 테스트")
    public void testRemove(){
        //when
        treeSet.add("Banana");
        treeSet.add("Apple");
        treeSet.add("Orange");

        //then
        assertTrue(treeSet.remove("Orange"));

        assertEquals(2,treeSet.size());
    }

    @Test
    @DisplayName("요소 중복 비허용 테스트")
    public void testDuplicate() {
        // when
        treeSet.add("Banana");
        treeSet.add("Apple");
        treeSet.add("Orange");

        // then
        assertFalse(treeSet.add("Banana"));

        assertEquals(3,treeSet.size());
    }

    @Test
    @DisplayName("요소 Null 비허용 테스트")
    public void testNullable() {
        //then
        assertThrows(NullPointerException.class, () ->{
            //when
            treeSet.add(null); // null 요소를 추가 > 예외 발생
        });
    }

    @Test
    @DisplayName("요소 정렬 테스트")
    public void testSort() {
        // when
        treeSet.add("Banana");
        treeSet.add("Apple");
        treeSet.add("Orange");

        // then
        List<String> expected = Arrays.asList("Apple", "Banana", "Orange");
        List<String> actual = new ArrayList<>(treeSet);

        assertEquals(expected, actual);
    }



}
