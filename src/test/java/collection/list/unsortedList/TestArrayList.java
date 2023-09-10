package collection.list.unsortedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestArrayList {

    /**
     * ArrayList :::
     * 배열을 이용하여 만든 리스트
     * 중복 허용 / 순서 존재 / 정렬 X / thread-safe X / Null O
     * 기본 크기는 10
     * 인덱스로 조회가 가능하다 -> 빠른 조회
     * 삽입/삭제시 뒤에 있는 데이터를 밀거나 당긴다. -> 삽입 삭제가 느리다. O(N)
     */

    private List<String> arrayList;

    @BeforeEach
    public void setUp() {
        arrayList = new ArrayList<>();
    }

    @Test
    @DisplayName("요소 추가 테스트")
    public void testAdd() {
        // when
        arrayList.add("Banana");
        arrayList.add("Apple");
        arrayList.add("Orange");

        // then
        assertEquals(3, arrayList.size());
    }

    @Test
    @DisplayName("요소 제거 테스트")
    public void testRemove() {
        // when
        arrayList.add("Banana");
        arrayList.add("Apple");
        arrayList.add("Orange");

        // then
        assertTrue(arrayList.remove("Banana"));
        
        assertEquals(2,arrayList.size());
    }

    @Test
    @DisplayName("요소 중복 허용 테스트")
    public void testDuplicate() {
        // when
        arrayList.add("Banana");
        arrayList.add("Apple");
        arrayList.add("Orange");
    
        // then
        assertTrue(arrayList.add("Banana"));

        assertEquals(4, arrayList.size());
    }

    @Test
    @DisplayName("요소 순서 유지 테스트")
    public void testOrder() {
        // when
        arrayList.add("Banana");
        arrayList.add("Apple");
        arrayList.add("Orange");

        // then
        List<String> expected = Arrays.asList("Banana","Apple","Orange");
        List<String> actual = new ArrayList<>(arrayList);

        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("널값 허용 테스트")
    public void testNullable() {
        // when
        arrayList.add("Banana");
        arrayList.add("Apple");
        arrayList.add("Orange");

        // then
        assertTrue(arrayList.add(null));

        assertEquals(4, arrayList.size());
    }


}
