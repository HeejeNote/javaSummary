package summary.java8.functional;

import java.util.function.*;

public class FunctionalType {

    public static void main(String[] args) {
        /**
         * Function<T,R> ::: T 타입을 받아서 R 타입을 리턴하는 함수 인터페이스
         * apply(T t,R r)
         * 함수 조합용 메서드 :::
         * compose (파라미터로 전달되는 함수를 먼저 연산)
         * andTen (파라미터로 전달되는 함수를 나중에 연산)
         */
        System.out.println(":::  Function<T,R> :::");

        Function<Integer, Integer> plus10 = (i) -> i + 10;
        System.out.println("plusTen.apply(1) ::: " + plus10.apply(2));

        Function<Integer, Integer> multiply2 = (i) -> i * 2;
        System.out.println("multiply2.apply(5) = " + multiply2.apply(5));
        System.out.println("-------------------------------------------------------");


        System.out.println(":::  Function<T,R> ::: compose 사용");
        // 입력 파라미터에 2를 곱한 후에 곱한 값에 10을 더한다.
        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2);
        System.out.println("multiply2AndPlus10 ::: " + multiply2AndPlus10.apply(5)); // 5 * 2 + 10 = 20
        System.out.println("-------------------------------------------------------");


        System.out.println(":::  Function<T,R> ::: andThen 사용");
        // 입력 파라미터에 10을 더한 후에 더한 값에 2를 곱한다.
        Function<Integer, Integer> plus10AndThenMultiply2 = plus10.andThen(multiply2);
        System.out.println("plus10AndThenMultiply2 ::: " + plus10AndThenMultiply2.apply(5)); // (5 + 10) * 2 = 30
        System.out.println("-------------------------------------------------------");


        System.out.println(":::  Function<T,R> ::: 변수 할당 없이 사용");
        // 변수 할당 없이 바로 사용
        System.out.println("plus10.andThen(multiply2).apply(5) ::: " + plus10.andThen(multiply2).apply(5));
        System.out.println("-------------------------------------------------------");


        /**
         * BIFunction<T,U,R> ::: T 타입, U 타입을 받아서 R 타입을 리턴하는 함수 인터페이스
         * apply(T t,U u)
         */
        System.out.println(":::  BIFunction<T,R> :::");
        BiFunction<Integer, Integer, Integer> biFunctionEx = (i, j) -> i * 2 + j;
        System.out.println("biFunctionEx = " + biFunctionEx.apply(5,10));
        System.out.println("-------------------------------------------------------");


        /**
         * Consumer<T> ::: T 타입을 받아서 아무값도 리턴하지 않는 함수 인터페이스
         * accept(T t)
         * 함수 조합용 메서드 andThne
         */
        System.out.println(":::  Consumer<T> :::");
        Consumer<Integer> printT = (i) -> System.out.println(i);
        //        Consumer<Integer> printT = System.out::println; // method Reference 사용

        printT.accept(10);

        System.out.println("-------------------------------------------------------");

        System.out.println(":::  Consumer<T> ::: andThen 사용 ");
        Consumer<String> printStr = (str) -> System.out.println("출력 ::: " + str);

        Consumer<String> upperStr = (str) -> {
            String uppercaseStr = str.toUpperCase();
            System.out.println("대문자 변환해서 출력 = " + uppercaseStr);
        };

        Consumer<String> printStr2 = printStr.andThen(upperStr);

        printStr2.accept("Hello");

        System.out.println("-------------------------------------------------------");


        /**
         * Supplier<T> ::: T 타입의 값을 제공하는 함수 인터페이스
         * get()
         */
        System.out.println(":::  Supplier<T> :::");
        Supplier<Integer> getT = () -> 10;
        System.out.println("getT = " + getT.get());
        System.out.println("-------------------------------------------------------");

        /**
         * Predicate<T> ::: T타입을 받아서 boolean을 리턴하는 함수 인터페이스
         * test(T t)
         * 함수 조합용 메서드
         * And ::: and 조건
         * Or  ::: or 조건
         * Negate ::: not 조건
         */
        System.out.println(":::  Predicate<T> ::: ");
        Predicate<Integer> isEven = (i) -> i % 2 == 0; // 짝수 검증 테스트
        System.out.println("isEven.test(2) = " + isEven.test(2));

        Predicate<Integer> isOdd = (i) -> i % 2 == 1; // 홀수 검증 테스트
        System.out.println("isOdd.test(3) = " + isOdd.test(3));

        Predicate<String> starsWithAlphaBatH = (s) -> s.startsWith("heeje"); // 시작 문자 검증 테스트
        System.out.println("starsWithAlphaBatH.test(\"heeje\") ::: " + starsWithAlphaBatH.test("heeje"));

        System.out.println("isEven.and(isOdd).test(2) = " + isEven.and(isOdd).test(2)); // 홀수이면서 짝수인지 ::: false
        System.out.println("isEven.and(isOdd).test(2) = " + isEven.or(isOdd).test(2)); // 홀수이거나 짝수이거나 ::: true
        System.out.println("isEven.negate().test(3) = " + isEven.negate().test(3)); // 짝수가 아니면 ::: true
        System.out.println("isEven.negate().test(2) = " + isEven.negate().test(2)); // 짝수이면 ::: false
        System.out.println("-------------------------------------------------------");

        /**
         * UnaryOperator<T> ::: Function<T,R> 입력값 타입과 반환값의 타입이 같으면 사용 가능한 함수
         */
        System.out.println(":::  UnaryOperator<T> ::: ");
        Function<Integer, Integer> f = (i) -> i + 5;
        System.out.println("f ::: " + f.apply(5));

        System.out.println(":: Function -> UnaryOperator ::");

        UnaryOperator<Integer> uo = (i) -> i + 5;
        System.out.println("uo ::: " + uo.apply(5));
        System.out.println("-------------------------------------------------------");

        /**
         * BinaryOperator<T> ::: BIFunction<T,U,R> 동일한 입력값의 타입과 반환값의 타입이 같으면 사용 가능한 함수
         */
        System.out.println(":::  BinaryOperator<T> ::: ");
        BiFunction<Integer, Integer, Integer> bif = (i, j) -> i * 2 + j;
        System.out.println("bif ::: " + bif.apply(5,10));

        System.out.println(":: BiFunction -> BinaryOperator ::");

        BinaryOperator<Integer> bio = (i,j) -> i * 2 + j;
        System.out.println("bio ::: " + bio.apply(5, 10));
        System.out.println("-------------------------------------------------------");


    }
}
