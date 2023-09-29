package summary.java8.defaultAndStaticMethod;


public interface IDefaultMethod {

    /**
     * @implSpec // 인터페이스에서 구현체 사용시에는 문서화로 내용을 상세하게 적어준다. 
     * 이 구현체는 gtName()으로 가져운 문자열을 대문자로 바꿔 출력한다.
     */
    default void printNameUpperCase(){
        /**
         * default Method ::: 인터페이스에 메서드 선언이 아닌 구현체를 제공하는 방법
         * -> default Method도 override 가능
         */
        System.out.println(getName().toUpperCase());
    }

    /**
     * static Method :::
     */
    static void printNumber(){
        System.out.println("12345");
    }

    /**
     * java.lang.Object 는 defulat Method로 사용할 수 없다. -> 추상메서드로 선언은 가능
     * @return
     */
    /*
    default String toString(){

    }
    */

    /**
     * abstract Method :::
     * -> 구현체 구현 필요 override
     */
    void printName();

    /**
     * abstract Method :::
     * -> 구현체 구현 필요 override
     */
    String getName();
}
