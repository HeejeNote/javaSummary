package collection.list.unsortedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

public class TestVector {

    /**
     * Vector :::
     * ArrayList와 비슷하게 배열을 이용하여 만든 리스트
     * 중복 허용 / 순서 존재 / 정렬 X / thread-safe O
     * thread-safe하다. -> 한번에 하나의 스레드로만 접근 가능
     * syncronized로 인해 get,put에 스레드마다 lock이 발생 -> 성능상 ArrayList에 비해 불리
     */

    private Vector<String> vector;

    @BeforeEach
    public void setUp() {
        vector = new Vector<>();
    }

    @Test
    @DisplayName("요소 추가 테스트")
    public void testAdd() {
        // when
        vector.add("Banana");
        vector.add("Apple");
        vector.add("Orange");

        // then
        assertEquals(3, vector.size());
    }

    @Test
    @DisplayName("요소 제거 테스트")
    public void testRemove() {
        // when
        vector.add("Banana");
        vector.add("Apple");
        vector.add("Orange");

        // then
        assertTrue(vector.remove("Banana"));

        assertEquals(2, vector.size());
    }

    @Test
    @DisplayName("요소 중복 테스트")
    public void testDuplicate() {
        // when
        vector.add("Banana");
        vector.add("Apple");
        vector.add("Orange");

        // then
        assertTrue(vector.add("Banana"));

        assertEquals(4, vector.size());
    }

    @Test
    @DisplayName("요소 순서 테스트")
    public void testOrder() {
        // when
        vector.add("Banana");
        vector.add("Apple");
        vector.add("Orange");

        // then
        List<String> expected = Arrays.asList("Banana", "Apple", "Orange");
        List<String> actual = new Vector<>(vector);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("널값 허용 테스트")
    public void testNullable() {
        // when
        vector.add("Banana");
        vector.add("Apple");
        vector.add("Orange");

        // then
        assertTrue(vector.add(null));

        assertEquals(4, vector.size());
    }

    @Test
    @DisplayName("스레드 세이프 테스트")
    public void testThreadSafe() {
        //given
        final int numThreads = 10; // 스레드 갯수
        final int numElementPerThread = 100; // 스레드당 처리할 요소 수

        List<Integer> vectors = new Vector<>(); // vector 생성
        Thread[] threads = new Thread[numThreads]; // 스레드 갯수의 스레드 생성

        // when
        for(int i= 0; i < numThreads; i++){ // 스레드 갯수만큼 반복
            threads[i] = new Thread(() -> { // 스레드 생성
                for(int j = 0; j < numElementPerThread; j ++){
                    vectors.add(j); // 각 스레드에서 백터에 요소 추가
                }
            });
            threads[i].start(); // 스레드 시작
        }

        for(int i = 0; i < numThreads; i++){
            try {
                threads[i].join(); // 모든 스레드 작업이 종료될 때까지 기다림(wait)
            } catch (InterruptedException e) { // 스레드가 중단,대기 상태가 되었을때 발생하는 예외
                Thread.currentThread().interrupt(); // 현재 스레드를 다시 인터럽트 상태로 설정
                e.printStackTrace();
            }
        }

        // then
        int expectedSize = numThreads * numElementPerThread;
        assertEquals(expectedSize, vectors.size());


    }
}
