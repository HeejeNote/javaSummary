package summary.java8structure.Annotation;

import java.util.Arrays;
import java.util.List;

@Chicken("양념")
@Chicken("마늘간장")
public class App {
    /**
     * @Target(TYPE_PARAMETER)
     * public @interface Chicken {
     * }

     */
    public static void main(String[] args) {

        /**
         * 어노테이션 가져오기 :::
         */
        Chicken[] chickens = App.class.getAnnotationsByType(Chicken.class);
        Arrays.stream(chickens).forEach(c -> {
            System.out.println("Chicken ::: " + c.value());
        });

        /**
         * 컨테이너로 감싼 어노테이션에서 가져오기 :::
         */
        ChickenContainer chickenContainers = App.class.getAnnotation(ChickenContainer.class);
        Arrays.stream(chickenContainers.value()).forEach(c -> {
            System.out.println("ChickenContainer :::" + c.value());
        });

    }

    /**
     * @Target(TYPE_PARAMETER) :::
     * 타입 파라미터 앞에 어노테이션 허용
     */
//    static class bbqChicken<@Chicken T> {
//        /**
//         * 메서드에 타입파라미터 지정시 :::
//         * 반환타입 앞에 선언
//         * @param c
//         * @param <C>
//         */
//        public static <@Chicken C> void print(C c) { // print(@Chicken C c) 는 에러 발생
//            System.out.println("print = " + c);
//        }
//    }

    /**
     * @Target(ElementType.TYPE_USE)
     * 타입을 선언하는 모든곳에서 사용 가능하다.
     */
//     static class jadamChicken<@Chicken T> {
//
//         public static <@Chicken C> void sort(@Chicken C c){
//             System.out.println("sort = " + c);
//         }
//    }
}
