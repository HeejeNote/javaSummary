package summary.codeModifyHandling.classLoaderExplain;

public class App {

    static String myName;

    static {
        myName = "heeje";
    }

    public static void main(String[] args) {
        System.out.println("상속 클래스 Check ::: " + App.class.getSuperclass()); // class java.lang.Object

        /**
         * 클래스 로더 시스템에서 로딩이 끝나면 해당 클래스 타입의 Class 객체를 생성하여 "힙" 영역에 저장
         */
        Class<App> app = App.class; // Class<App> 타입 객체 생성시 힙 영역에 저장
        System.out.println("app ::: " + app); // class summary.WorkApp

        ClassLoader classLoader = App.class.getClassLoader();

        /**
         * 부트스트랩 클래스 로더 :::
         * JAVA_HOME\lib에 있는 코어 자바 API를 제공한다.
         * 최상위 우선순위를 가진 클래스 로더
         */
        System.out.println("classLoader.getParent().getParent() = " + classLoader.getParent().getParent()); // null
        // PlatformClassLoader의 부모가 존재 하는데 네이티브 코드로 작성되어 있어서 부트스트랩 클래스로더는 자바에서 참조해서 출력을 할 수 없다.

        /**
         * 플랫폼 클래스로더 :::
         * JAVA_HOME\lib\ext 폴더 또는 java.ext.dirs 시스템 변수에 해당하는 위치에 있는 클래스를 읽는다
         */
        System.out.println("classLoader.getParent() = " + classLoader.getParent()); //jdk.internal.loader.ClassLoaders$PlatformClassLoader@4a574795

        /**
         * 애플리케이션 클래스로더 :::
         * 애플리케이션 클래스패스(애플리케이션 실행할 때 주는 -classpath 옵션 또는 java.class.path 환경 변수의 값에 해당하는 위치)에서 클래스를 읽는다
         */
        System.out.println("classLoader = " + classLoader); // jdk.internal.loader.ClassLoaders$AppClassLoader@659e0bfd

    }
}
