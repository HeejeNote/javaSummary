package summary.codeModifyHandling.AnnotationExpalin;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        Arrays.stream(Picture.class.getAnnotations()).forEach(System.out::println);
        // 아무 결과도 나오지 않는다.
        // 어노테이션에 @Retention(RetentionPolicy.RUNTIME) 추가 후에는
        // -> @summary.codeModifyHandling.AnnotationExpalin.MyAnnotation()

        // 어노테이션에 필드 값을 추가한 후
        // -> @summary.codeModifyHandling.AnnotationExpalin.MyAnnotation(name="heeje", age="31")

        Arrays.stream(MyPicture.class.getAnnotations()).forEach(System.out::println);
        // -> @summary.codeModifyHandling.AnnotationExpalin.MyAnnotation(name="heeje", age="31")

        Arrays.stream(MyPicture.class.getDeclaredAnnotations()).forEach(System.out::println);
        // -> 자신의 annotation 참조는 없기 때문에 아무 결과도 나오지 않음

        /**
         * 어노테이션의 필드값 호출
         */
        Arrays.stream(Picture.class.getDeclaredFields()).forEach(f -> {
            Arrays.stream(f.getAnnotations()).forEach(a -> {
                if( a instanceof MyAnnotation){
                    MyAnnotation myAnnotation = (MyAnnotation) a;
                    System.out.println("myAnnotation.name() = " + myAnnotation.name());
                    System.out.println("myAnnotation = " + myAnnotation.age());
                }
            });
        });

        Arrays.stream(Picture.class.getAnnotations()).forEach(a -> {
            if(a instanceof MyAnnotation){
                MyAnnotation myAnnotation = (MyAnnotation) a;
                System.out.println("aaa myAnnotation.name() = " + myAnnotation.name());
                System.out.println("aaa myAnnotation = " + myAnnotation.age());
            }
        });


    }
}
