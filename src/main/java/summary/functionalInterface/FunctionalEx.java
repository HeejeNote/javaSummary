package summary.functionalInterface;

@FunctionalInterface
public interface FunctionalEx {

    /**
     * 추상메서드가 하나만 존재하면 함수형 인터페이스이다. (abstract 생략가능)
     * 함수형 인터페이스 선언을 하려면 애노테이션 @FunctionalInterface
     */
    void doIt();

    /**
     * 추상메서드가 하나 보다 많게 존재하면 함수형 인터페이스가 X (abstract 생략가능)
     */
//    void doItAgain(); // 주석을 해제하면 애노테이션의 컴파일 에러에 걸린다.


    /**
     * 다른 형태의 메서드가 여러개 존재하더라도 추상메서드가 하나이면 함수형 인터페이스이다.
     */
    static void printName() { // (public 생략 가능)
        System.out.println("heeje");
    }

    default void printAge(){
        System.out.println("31");
    }


}
