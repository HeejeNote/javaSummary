package summary.java8.defaultAndStaticMethod.CollectionMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {

        List<String> name = new ArrayList<>();
        name.add("kim");
        name.add("lee");
        name.add("sung");
        name.add("park");


        /**
         * ::: Stream :::
         * map ::: 요소를 매핑해서 변환
         * filter ::: 요소를 조건에 따라 걸러냄
         * count ::: 갯수 연산
         */
        long num = name.stream().map(String::toUpperCase) // name.stream().map(s -> s.toUpperCase)
                .filter(s -> s.startsWith("S"))
                .count();
        System.out.println("stream().map().filter().count() ::: " + num); // 1
        System.out.println("-----------------------------");


        /**
         * ::: Stream :::
         * collect ::: 원하는 자료형으로 변환
         * -> Set
         */
        Set set = name.stream().map(String::toUpperCase)
                .filter(s -> s.startsWith("S"))
                .collect(Collectors.toSet());

        System.out.println("stream().map().filter().collect() -> return Set ::: " + set); // [SUNG]
        System.out.println("-----------------------------");


        /**
         * ::: Stream :::
         * collect ::: 원하는 자료형으로 변환
         * -> List
         */
        List<String> ls = name.stream().map(String::toUpperCase)
                .filter(s -> s.startsWith("S"))
                .toList(); // .collect(Collectors.toList())

        System.out.println("stream().map().filter().collect() -> return List ::: " + ls); // [SUNG]
        System.out.println("-----------------------------");


        /**
         * ::: removeIf :::
         * 조건에 해당하는 값만 제거
         */
        name.removeIf(s -> s.startsWith("k"));

        System.out.println("removeIf ::: " + name); // [lee, sung, park]
        System.out.println("-----------------------------");


    }
}
