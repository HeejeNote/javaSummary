package summary.java8.defaultAndStaticMethod;

public class App {

    public static void main(String[] args) {

        IDefaultMethod iDefaultMethod = new DefaultMethod("hj"); // 객체 생성

        iDefaultMethod.printName(); // 인터페이스 구현 메소드로 이름 출력

        iDefaultMethod.printNameUpperCase(); // 인터페이스 default 메소드로 대문자로 바꿔서 이름 출력

        IDefaultMethod.printNumber(); // static Method 사용 -> 타입을 참조해서 사용

    }
}
