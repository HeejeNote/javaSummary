package summary.java8structure.Optional;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalFeature {

    public static void main(String[] args) {

        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1L, "Spring Boot", true));
        springClasses.add(new OnlineClass(2L, "Spring Data jpa", true));
        springClasses.add(new OnlineClass(3L, "Spring MVC", false));
        springClasses.add(new OnlineClass(4L, "Spring Core", false));
        springClasses.add(new OnlineClass(5L, "Spring Batch", false));


//        OnlineClass springBoot = new OnlineClass(1L,"Spring Boot",true);
//        Duration studyDuration = springBoot.getProgress().getStudyDuration(); // NullPointerException
//        System.out.println("studyDuration = " + studyDuration);

        /**
         * null 체크를 조건문으로 처리하게 되면 실수를 할 수 있다.
         * -> null 체크를 하기 이전에 null을 반환하는게 문제이다.
         */
//        OnlineClass springBoot = new OnlineClass(1L,"Spring Boot",true);
//        Optional<Progress> progress = springBoot.getProgress();
//        if(progress != null) {
//            System.out.println("progress = " + progress.getStudyDuration());
//        }

        OnlineClass springBoot = new OnlineClass(1L, "Spring Boot", true);
        Optional<Progress> progress = springBoot.getProgress();
        System.out.println("progress = " + progress); // Optional.empty




    }
}
