package summary.java8structure.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFeature {
    public static void main(String[] args) {

        /**
         * Stream ::: 연속된 데이터를 처리하는 Operation 모음
         * -> 데이터를 담고 있는 저장소가 아니다.
         * -> 스트림이 처리하는 데이터 소스를 변경하지 않는다.
         * 중개 오퍼레이터 / 종료 오퍼레이터 두 가지로 나뉜다.
         */

        List<String> names = new ArrayList<>();
        names.add("lee");
        names.add("kim");
        names.add("sung");
        names.add("park");

        /**
         * 중개 오퍼레이터 ::: filter / map / limit / skip / sorted ...
         * Stream을 리턴한다.
         * lazy하다. -> 종료 오퍼레이터가 오기전에는 결과가 지연됨.
         */
        names.stream().map(s -> {
            System.out.println("(intermediate operation ::: " + s);
            return s.toUpperCase();
        }); // 중개 오퍼레이터만 있으므로 결과 처리가 되지 않고 lazy 된다.


        /**
         * 종료 오퍼레이터 ::: collect, allMatch, count, forEach, min ,max ...
         *
         */
        names.stream().map(s -> {
            System.out.println("terminal operation ::: " + s + " " + Thread.currentThread().getName()); // thread ::: main(메인스레드)
            return s.toLowerCase();
        }).collect(Collectors.toSet()); // 종료 오퍼레이터가 있으므로 결과가 출력된다.

        System.out.println("-----------------------------------");

        names.forEach(System.out::println); // 원본 데이터 소스를 변경하지 않는다.

        System.out.println("-----------------------------------");

        // 대규모 데이터 처리를 하기에는 처리가 느리다.
        for(String name : names){
            if(name.startsWith("k")) {
                System.out.println(Thread.currentThread().getName()); // thread ::: main(메인스레드)
                System.out.println("for ::: " + name.toUpperCase());
            }
        }

        System.out.println("-----------------------------------");

        List<String> nameList = new ArrayList<>();
        nameList.add("lee");
        nameList.add("kim");
        nameList.add("sung");
        nameList.add("park");
        nameList.add("jung");
        nameList.add("ha");
        nameList.add("ju");

        /**
         * parallelStream() ::: 대규모 데이터 처리를 병렬로 처리.
         * -> 정말 대규모의 데이터가 아니면 stream()이 빠르다. (parallelStream() 적용시에 직접 속도 비교가 필요)
         * -> 왜냐하면 스레드를 생성하는 것 자체도 리소스이기 때문에
         * 메인 스레드 / 병렬처리를 위해 생성한 ForkJoinPool 스레드
         * main // 메인 스레드
         * ForkJoinPool.commonPool-worker-1 // ForkJoinPool 스레드
         * ForkJoinPool.commonPool-worker-2 // ForkJoinPool 스레드
         * -> 메인 스레드에서 먼저 수행할 작업을 분할하고 ForkJoinPool에 넘기는 역할
         * -> 나머지 작업은 ForkJoinPool에서 스레드를 생성하고 병렬로 처리
         * -> commonPool-worker-1,2,3... 갯수는 메인 스레드에서 작업을 분할하고 넘기는 것에 따라 달라진다.
         */
        List<String> collect = nameList.parallelStream().map((s) -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());
//        jung main
//        park main
//        ju main
//        ha main
//        lee ForkJoinPool.commonPool-worker-2
//        sung ForkJoinPool.commonPool-worker-2
//        kim ForkJoinPool.commonPool-worker-1


    }
}
