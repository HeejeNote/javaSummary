package summary.java8structure.defaultAndStaticMethod.iterableMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class App {
    public static void main(String[] args) {

        List<String> name = new ArrayList<>();
        name.add("kim");
        name.add("lee");
        name.add("sung");
        name.add("park");

        /**
         * Iterable
         * forEach
         * -> forEach(Consumer<T>)
         */
        System.out.println("::: forEach :::");
        name.forEach(System.out::println); // name.forEach(i -> System.out.println(i));
        System.out.println("-----------------------------");

        /**
         * Iterable
         * Spliterator<T>
         * tryAdvance() ::: 요소를 순회 <==> hasNext() 와 같은 기능
         * trySplit() ::: 반으로 쪼갠다.
         */
        System.out.println("::: Spliterator :::");
        Spliterator<String> spliterator = name.spliterator();
        while (spliterator.tryAdvance(System.out::println));
        System.out.println("-----------------------------");

        Spliterator<String> spliteratorTotal = name.spliterator();
        Spliterator<String> spliteratorHalf = spliteratorTotal.trySplit(); // trySplit()을 하면 원래 전체 값이 절반으로 줄고 나머지 절반이 출력
        while (spliteratorTotal.tryAdvance(System.out::println));
        System.out.println("-----------------------------");
        while (spliteratorHalf.tryAdvance(System.out::println));
    }
}
