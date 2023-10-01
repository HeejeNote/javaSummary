package summary.java8structure.Optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalEx {
    public static void main(String[] args) {

        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1L, "Spring Boot", true));
        springClasses.add(new OnlineClass(5L, "rest api development", false));

        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("Spring"))
                .findFirst();

        Optional<OnlineClass> optionalNull = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("jpa"))
                .findFirst();

        /**
         * isPresent()
         * isEmpty()
         * 값 유무 확인 ::: boolean
         */
        System.out.println("optional.isPresent() ::: " + optional.isPresent());
        System.out.println("optional.isEmpty() ::: " + optional.isEmpty());
        System.out.println("optionalNull.isPresent() ::: " + optionalNull.isPresent());
        System.out.println("optionalNull.isEmpty() ::: " + optionalNull.isEmpty());
        System.out.println("-----------------------------------");

        /**
         * get()
         * 값 가져 오기 :::
         * -> 값이 없을 때 꺼내려고 하면 런타임 에러가 발생한다.
         * -> if문으로 체크해야하는 로직이 추가되야함. 이런 방법 보다는 Optional에 다른 API를 사용하는 것이 좋다.
         */

//        OnlineClass onlineClass = optional.get();
//        System.out.println("onlineClass.getTitle() ::: " + onlineClass.getTitle());

        /**
         * ifPresent()
         * 값이 있으면 :::
         */
        optional.ifPresent(oc -> System.out.println("ifPresent() ::: "+ oc.getTitle()));
        optionalNull.ifPresent(oc -> System.out.println("ifPresent() ::: "+ oc.getTitle()));
        System.out.println("-----------------------------------");

        /**
         * orElse()
         * 값이 있으면 가져오고 없으면 그 값을 가지고 ~~ 리턴 :::
         * -> 연산이 값의 유무에 상관없이 인스턴스화가 발생한다.
         * -> 상수로 만들어져 있는 것들은 orElse가 적합
         */
        System.out.println("::: orElse() ::: ");
        OnlineClass onlineClassElse1 = optional.orElse(createNewClasses()); // 연산이 값의 유무에 상관없이 일어난다.
//        OnlineClass onlineClassElse2 = optionalNull.orElse(createNewClasses()); // 연산이 값의 유무에 상관없이 일어난다.
        System.out.println("onlineClassElse1 = " + onlineClassElse1.getTitle());
//        System.out.println("onlineClassElse2 = " + onlineClassElse2.getTitle());

        System.out.println("-----------------------------------");
        // 값이 없는 경우
//        create new Online class
//        onlineClass = New class
        // 값이 있는 경우
//        create new Online class
//        onlineClass = Spring Boot

        /**
         * orElseGet()
         * 값이 있으면 가져오고 없으면 Supplier가 실행된다 :::
         * -> 파라미터로 Supplier를 받는다.
         * -> 값이 있으면 Supplier가 실행되지 않는다.
         * -> 동적으로 생성이 되어야 하는 것이라면 orElseGet()이 적합
         */
        System.out.println("::: orElseGet() ::: ");
        OnlineClass onlineClassOrElseGet1 = optional.orElseGet(OptionalEx::createNewClasses);
//        OnlineClass onlineClassOrElseGet2 = optionalNull.orElseGet(OptionalEx::createNewClasses);
        System.out.println("onlineClassOrElseGet1.getTitle() = " + onlineClassOrElseGet1.getTitle());
//        System.out.println("onlineClassOrElseGet2.getTitle() = " + onlineClassOrElseGet2.getTitle());

        System.out.println("-----------------------------------");
        //값이 없는 경우
//        create new Online class
//        onlineClass1.getTitle() = New class
        //값이 있는 경우
//        onlineClass1.getTitle() = Spring Boot

        /**
         * orElseThrow()
         * 값이 없으면 에러를 던진다 :::
         */
        System.out.println("::: orElseThrow() ::: ");
        OnlineClass onlineClassOrElseThrow1 = optional.orElseThrow(IllegalStateException::new);
//        OnlineClass onlineClassOrElseThrow2 = optionalNull.orElseThrow(IllegalStateException::new);
        System.out.println(onlineClassOrElseThrow1.getTitle());
//        System.out.println(onlineClassOrElseThrow2.getTitle());
        System.out.println("-----------------------------------");

        /**
         * Optional filter ::: Optional로 감싸져서 결과가 나온다.
         */
        System.out.println("::: filter ::: ");
        Optional<OnlineClass> optionalFilter = optional.filter(oc -> !oc.isClosed());
        System.out.println(optionalFilter.isEmpty());
        System.out.println("-----------------------------------");

        /**
         * Optional map ::: Optional로 감싸져서 결과가 나온다.
         */
        System.out.println("::: Optional map -> return Long ::: ");
        Optional<Long> returnLong = optional.map(oc -> oc.getId());
        System.out.println(returnLong.isPresent());
        System.out.println("-----------------------------------");

        System.out.println("::: Optional map -> return Optional ::: ");
        Optional<Optional<Progress>> progressMap1 = optional.map(OnlineClass::getProgress);
        Optional<Progress> progressMap2 = progressMap1.orElse(Optional.empty()); // Optional이 2중으로 있는경우 한번더 꺼내서 사용해야 한다.
        System.out.println(progressMap2.isPresent());
        System.out.println("-----------------------------------");

        System.out.println("::: Optional flatMap ::: ");
        Optional<Progress> progressFlatMap = optional.flatMap(OnlineClass::getProgress);
        System.out.println(progressFlatMap.isPresent());
        System.out.println("-----------------------------------");
    }

    private static OnlineClass createNewClasses() {
        System.out.println("create new Online class");
        return new OnlineClass(10L, "New class", false);
    }
}
