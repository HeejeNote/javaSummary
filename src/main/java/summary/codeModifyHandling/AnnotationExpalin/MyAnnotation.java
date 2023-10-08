package summary.codeModifyHandling.AnnotationExpalin;

import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE ,ElementType.FIELD}) // 어노테이션을 타입과 필드에만 달 수 있게 설정
@Inherited
public @interface MyAnnotation {

    /**
     * Annotation 이란?
     * 메타데이터를 추가하는 특별한 형태의 주석
     * -> 코드에 대한 부가적인 정보를 제공
     * -> 컴파일러, 런타임 시스템 또는 다른 도구에 대한 지시사항을 제공하는 데 사용
     * Annotation을 생성하면 @interface 라는 키워드가 사용된다.
     */

    /**
     * @Retention(RetentionPolicy.RUNTIME)
     * -> Annotation은 클래스와 소스에는 남아 있지만 런타임까지 유지 되지 않는다.
     * --> 런타임까지 유지시키려면 @Retention(RetentionPolicy.RUNTIME) Annotation을 추가해야 한다.
     */

    /**
     * 어노테이션에서 사용할 수 있는 필드 타입
     *     int intValue();
     *     String stringValue();
     *     MyEnum enumValue();
     *     Class<?> classValue();
     *     OtherAnnotation annotationValue();
     *     int[] intArrayValue();
     *     String[] stringArrayValue();
     *     MyEnum[] enumArrayValue();
     *     Class<?>[] classArrayValue();
     */

    String name() default "heeje";

    String age() default "31";


}
