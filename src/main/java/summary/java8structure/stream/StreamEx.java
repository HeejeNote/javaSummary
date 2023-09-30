package summary.java8structure.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;


public class StreamEx {
    public static void main(String[] args) {

        List<OnlineClass> classes = new ArrayList<>();
        classes.add(new OnlineClass(1L, "Spring Boot", true));
        classes.add(new OnlineClass(2L, "Spring Data jpa", true));
        classes.add(new OnlineClass(3L, "Spring MVC", false));
        classes.add(new OnlineClass(4L, "Spring Core", false));
        classes.add(new OnlineClass(5L, "Spring Batch", false));
        classes.add(new OnlineClass(6L, "CPP", false));
        classes.add(new OnlineClass(7L, "Python", false));
        System.out.println("-----------------------------------");

        System.out.println("::: Spring으로 시작하는 수업 ::: ");
        classes.stream()
                .filter(oc -> oc.getTitle().startsWith("Spring"))
                .forEach(oc -> System.out.println("oc.getId() = " + oc.getId() + " " + oc.getTitle()));

        System.out.println("-----------------------------------");


        System.out.println("::: close 되지 않은 수업 ::: ");

        // filter 부분 람다 사용
        classes.stream()
                .filter(oc -> !oc.isClosed())
                .forEach(oc -> System.out.println("oc.isClosed Lambda ::: " + oc.getId() + " " + oc.getTitle() + " " + oc.isClosed()));

        // filter 부분 람다 -> 메소드 레퍼런스 변환
        classes.stream() // 메소드 레퍼런스는 !OnlineClass::isclosed 같은 처리가 불가능하다.
                .filter(Predicate.not(OnlineClass::isClosed)) // Predicate.not() ::: static Method로 not 연산해서 걸러낸다.
                .forEach(oc -> System.out.println("oc.isClosed Method Reference ::: " + oc.getId() + " " + oc.getTitle() + " " + oc.isClosed()));
        System.out.println("-----------------------------------");


        System.out.println("::: 수업 이름만 모아서 스트림 만들기 ::: ");

//        classes.stream()
//                .map(oc -> oc.getTitle())
//                .forEach(s -> System.out.println(s));

        classes.stream()
                .map(OnlineClass::getTitle)
                .forEach(System.out::println);
        System.out.println("-----------------------------------");

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(8L, "자바 8", true));
        javaClasses.add(new OnlineClass(9L, "자바 11", true));
        javaClasses.add(new OnlineClass(10L, "자바 17", true));

        List<List<OnlineClass>> events = new ArrayList<>();
        events.add(classes); // 7개 List
        events.add(javaClasses); // 3개 List

        System.out.println("::: 두 수업 목록에 들어 있는 모든 수업 출력 ::: ");
//        events.stream().flatMap(li -> li.stream()) // lambda
//                .forEach(st -> System.out.println(st.getId() + " " + st.getTitle()));

        /**
         * flatMap(x -> x.stream) 스트림 안의 여러개의 List들을 꺼내서 하나의 stream 선상으로 불러온다.
         * List<List<OnlineClass>> -> List<OnlineClass> 리스트안의 리스트들을 꺼내서 밖에 리스트로 합쳐준다고 생각하면 된다.
         */
        events.stream().flatMap(Collection::stream) // Method Reference
                .forEach(st -> System.out.println(st.getId() + " " + st.getTitle()));
        System.out.println("-----------------------------------");


        /**
         *  Stream.iterate ::: 반복 처리
         *  skip ::: 처리 결과 건너 뛰기
         *  limit ::: 최대 갯수 처리
         */
        System.out.println("::: 10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 뺴고 최대 10개 까지만 ::: ");
        Stream.iterate(10, i -> i + 1) // Stream.iterate(시작값, 연산 처리)
                .skip(10) // 10개의 처리 결과는 skip
                .limit(10) // 결과는 10개 까지만
                .forEach(System.out::println);
        System.out.println("-----------------------------------");

        System.out.println("::: 자바 수정 중에 11이 들어 있는 수업이 있는지 체크 :::");
        boolean contains11 = javaClasses.stream()
                .anyMatch(oc -> oc.getTitle().contains("11")); // boolean을 리턴하기 때문에 바로 종료
        System.out.println("contains11 ::: " + contains11);
        System.out.println("-----------------------------------");

        System.out.println("::: classes 수업 중에 제목에 Spring이 들어간 것만 모아서 List로 만들기 :::");
        List<String> sl = classes.stream()
                .filter(oc -> oc.getTitle().contains("Spring"))
                .map(OnlineClass::getTitle)
                .toList();
        sl.forEach(System.out::println);
        System.out.println("-----------------------------------");
    }
}
