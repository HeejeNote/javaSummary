package collection.list.unsortedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestLinkedList {

    /**
     * LinkedList :::
     * 노드와 포인트를 이용하여 만든 리스트
     * 중복 허용 / 순서 존재 / 정렬 X / thread-safe X
     * 포인터로 노드를 연결 -> 삽입/삭제가 빠르다
     * 첫 노드부터 순회해야 한다. -> 조회가 느리다.
     */

    private List<String> linkedList;

    @BeforeEach
    public void setUp() {
        //given
        linkedList = new LinkedList<>();
    }

    @Test
    @DisplayName("요소 추가 테스트")
    public void testAdd() {
        // when
        linkedList.add("Banana");
        linkedList.add("Apple");
        linkedList.add("Orange");
        
        // then
        assertEquals(3, linkedList.size());
    }

    @Test
    @DisplayName("요소 제거 테스트")
    public void testRemove() {
        // when
        linkedList.add("Banana");
        linkedList.add("Apple");
        linkedList.add("Orange");

        // then
        assertTrue(linkedList.remove("Banana"));

        assertEquals(2, linkedList.size());
    }

    @Test
    @DisplayName("요소 중복 허용 테스트")
    public void testDuplicate() {
        // when
        linkedList.add("Banana");
        linkedList.add("Apple");
        linkedList.add("Orange");

        // then
        assertTrue(linkedList.add("Banana"));

        assertEquals(4, linkedList.size());
    }

    @Test
    @DisplayName("요소 순서 유지 테스트")
    public void testOrder() {
        // when
        linkedList.add("Banana");
        linkedList.add("Apple");
        linkedList.add("Orange");

        // then
        List<String> expected = Arrays.asList("Banana", "Apple", "Orange");
        List<String> actual = new LinkedList<>(linkedList);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("널값 허용 테스트")
    public void testNullable() {
        // when
        linkedList.add("Banana");
        linkedList.add("Apple");
        linkedList.add("Orange");

        // then
        assertTrue(linkedList.add(null));

        assertEquals(4, linkedList.size());
    }

}
