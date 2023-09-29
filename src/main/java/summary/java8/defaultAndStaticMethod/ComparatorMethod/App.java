package summary.java8.defaultAndStaticMethod.ComparatorMethod;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class App {
    public static void main(String[] args) {

        List<String> name = new ArrayList<>();
        name.add("kimalal");
        name.add("leeeun");
        name.add("sungheeje");
        name.add("park");

        /**
         * Comparator ::: 정렬
         */
        System.out.println("::: Comparator :::");
        name.sort(String::compareToIgnoreCase); // name.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        name.forEach(System.out::println); // name.forEach(s -> System.out.println(s));
        System.out.println("--------------------------------------");


        /**
         * Comparator ::: 역정렬
         * -> .reverse()
         */
        System.out.println("::: Comparator :::");
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        name.sort(compareToIgnoreCase.reversed());
        name.forEach(System.out::println);
        System.out.println("--------------------------------------");

        /**
         * Comparator ::: 역정렬 + 조건
         * -> thenComparing ::: 두번째 정렬 조건
         */
        System.out.println("::: Comparator :::");
        Comparator<String> compareToIgnoreCase2 = String::compareToIgnoreCase;
        name.sort(compareToIgnoreCase2.reversed().thenComparing(String::length)); // thenComparing 두번쨰 정렬 조건
        name.forEach(System.out::println);
        System.out.println("--------------------------------------");
    }
}
