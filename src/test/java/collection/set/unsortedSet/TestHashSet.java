package collection.set.unsortedSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;


import static org.junit.jupiter.api.Assertions.*;


public class TestHashSet {

    /**
     * HashSet :::
     * 해시 함수를 이용하여 만든 Set
     * 중복 X / 순서 X / 정렬 X / thread-safe X / NULL O
     * 요소가 저장된 순서를 보장 하지 않으며, 요소는 해시 코드에 따라 저장
     * null 요소를 한번만 허용
     * 정렬된 순서로 요소에 접근 하려면 별도로 정렬 작업을 수행 해야 함 ex) ArrayList 또는 배열에 담아서 정렬
     */

    private Set<String> hashSet;

    @BeforeEach
    public void setUp(){
        //given
        hashSet = new HashSet<>();
    }

    @Test
    @DisplayName("요소 추가 테스트")
    public void testAdd(){
        //when
        hashSet.add("Banana");
        hashSet.add("Apple");
        hashSet.add("Orange");

        //then
        assertEquals(3, hashSet.size());
    }

    @Test
    @DisplayName("요소 제거 테스트")
    public void testRemove(){

        // when
        hashSet.add("Banana");
        hashSet.add("Apple");
        hashSet.add("Orange");

        // then
        assertTrue(hashSet.remove("Banana"));

        assertEquals(2, hashSet.size());

    }

    @Test
    @DisplayName("요소 중복 비허용 테스트")
    public void testDuplicate(){
        //when
        hashSet.add("Banana");
        hashSet.add("Apple");
        hashSet.add("Orange");

        //then
        assertFalse(hashSet.add("Apple"), "요소 중복 에러 발생");

        assertEquals(3,hashSet.size());

    }

    @Test
    @DisplayName("널값 허용 테스트")
    public void testNullable() {
        // when
        hashSet.add("Banana");
        hashSet.add("Apple");
        hashSet.add("Orange");

        // then
        assertTrue(hashSet.add(null));

        assertEquals(4, hashSet.size());
    }

}
