package summary.java8structure.methodReference;

public class Greeting {

    private String name;

    public Greeting() {
    }

    public Greeting(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 인스턴스 메소드
    public String hello(String name){
        return "hello " + name;
    }

    // static 메소드
    public static String hi(String name){
        return "hi " + name;
    }
}
