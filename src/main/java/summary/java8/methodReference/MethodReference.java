package summary.java8.methodReference;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MethodReference {
    public static void main(String[] args) {
        /**
         * 타입::스태틱 메소드
         * 스태틱 메소드 참조 예시 hi
         */
        // UnaryOperator<String> hi = name -> Greeting.hi(name);
        UnaryOperator<String> hi = Greeting::hi;
        System.out.println("hi = " + hi.apply("hj"));

        /**
         * 객체 레퍼런스:: 인스턴스 메소드
         * 인스턴스 메소드 참조 예시 hello
         */
        Greeting greeting = new Greeting();
        // UnaryOperator<String> hello = name -> greeting.hello(name);
        UnaryOperator<String> hello = greeting::hello;
        System.out.println("hello = " + hello.apply("hj"));

        /**
         * 타입::new
         * default 생성자 참조 예시
         */
        // Supplier<Greeting> newGreeting = () -> new Greeting();
        Supplier<Greeting> newGreeting = Greeting::new;
        Greeting greeting1 = newGreeting.get();
        System.out.println("greeting1 = " + greeting1.hello("hj"));

        /**
         * 타입::new
         * 파라미터를 받는 생성자 참조 예시
         */
        // Function<String, Greeting> heejeGreeting = (name) -> new Greeting(name);
        Function<String, Greeting> heejeGreeting = Greeting::new;
        Greeting hj = heejeGreeting.apply("hj");
        System.out.println("hj.getName() = " + hj.getName());

        /**
         * 타입 :: 인스턴스 메서드
         * 임의 객체의 인스턴스 메소드 참조
         */
        String[] names = {"cross", "boss", "asics"};

//        Arrays.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return 0; // o1 > o2 음수 o1 = o2 0 o1 < o2 양수
//            }
//        });

//        Arrays.sort(names, (o1,o2) -> 0);

        Arrays.sort(names, String::compareToIgnoreCase); // String 클래스의 compareToIgnoreCase 메서드 참조
        System.out.println(Arrays.toString(names));
    }
}
