package summary.codeModifyHandling.reflectionApi;

import java.lang.reflect.Modifier;
import java.util.Arrays;

public class App {
    /**
     * 리플렉션 API :::
     * 리플렉션의 시작 -> Class<T>
     * Class<T> 로 클래스 정보를 가져올 수 있고 아래는 가져올 수 있는 정보들
     * ● 필드 (목록) 가져오기
     * ● 메소드 (목록) 가져오기
     * ● 상위 클래스 가져오기
     * ● 인터페이스 (목록) 가져오기
     * ● 애노테이션 가져오기
     * ● 생성자 가져오기
     * 등등등...
     */
    public static void main(String[] args) throws ClassNotFoundException {

        /**
         * 클래스 인스턴스 접근 방법
         */
        System.out.println("::: Class Instance 접근 방법 :::");
        // 1. 클래스 타입으로 호출
        // JVM이 모든 클래스를 로딩 한 다음 Class<T>의 인스턴스가 생성된다 -> “타입.class”로 접근
        Class<Book> bookClass1 = Book.class;
        System.out.println("bookClass1 = " + bookClass1); // class summary.codeModifyHandling.reflectionExplain.Book
        System.out.println("----------------------------------");

        // 2. 인스턴스를 생성하여 호출
        // 모든 인스턴스는 getClass() 메소드를 가지고 있다 -> “인스턴스.getClass()”로 접근
        Book book = new Book();
        Class<? extends Book> bookClass2 = book.getClass();
        System.out.println("bookClass2 = " + bookClass2); // class summary.codeModifyHandling.reflectionExplain.Book
        System.out.println("----------------------------------");

        // 3. 클래스를 문자열로 호출
        // Class.forName(“FQCN”) // 풀 패키지 클레스 네임
        // forName으로 찾을 수 없으면 ClassNotFoundException 예외가 발생한다.
        Class<?> bookClass3 = Class.forName("summary.codeModifyHandling.reflectionApi.Book");
        System.out.println("bookClass3 = " + bookClass3); // class summary.codeModifyHandling.reflectionExplain.Book
        System.out.println("----------------------------------");

        /**
         * 접근제어자 public 클래스의 필드 조회 :::
         */
        System.out.println("::: 클래스의 접근제어자 public 필드 호출 :::");
        Arrays.stream(bookClass1.getFields()).forEach(System.out::println);
        // public java.lang.String summary.codeModifyHandling.reflectionExplain.Book.publicVariable
        System.out.println("----------------------------------");

        /**
         * 접근제어자 상관없이 클래스의 모든 필드 조회 :::
         */
        System.out.println("::: 클래스의 접근제어자 상곤없이 모든 필드 호출 :::");
        Arrays.stream(bookClass1.getDeclaredFields()).forEach(System.out::println);
        //  private static java.lang.String summary.codeModifyHandling.reflectionExplain.Book.privateStaticVariable
        //  private static final java.lang.String summary.codeModifyHandling.reflectionExplain.Book.privateStaticFinalVariable
        //  private java.lang.String summary.codeModifyHandling.reflectionExplain.Book.privateVariable
        //  public java.lang.String summary.codeModifyHandling.reflectionExplain.Book.publicVariable
        //  protected java.lang.String summary.codeModifyHandling.reflectionExplain.Book.protectedVariable
        System.out.println("----------------------------------");

        /**
         * 클래스의 필드의 값을 조회하는 방법 :::
         * -> 인스턴스를 생성해야 필드의 값을 가져올 수 있다.
         */
        // 인스턴스를 생성해서 클래스에 접근한 두번째 방법으로 사용해서 진행 -> bookClass2
        System.out.println("::: 클래스의 필드의 값을 호출하는 방법 :::");
        Arrays.stream(bookClass2.getDeclaredFields()).forEach(f-> {
            try{
                f.setAccessible(true); // setAccessible(true) 옵션을 true로 주지 않으면 접근할 수 없다.
                System.out.printf("::: path ::: %s ::: value ::: %s\n", f, f.get(book));
            }catch(IllegalAccessException e){
                e.printStackTrace();
            }
        });
// ::: path ::: private static java.lang.String summary.codeModifyHandling.reflectionExplain.Book.privateStaticVariable ::: value ::: privateStaticVariable
// ::: path ::: private static final java.lang.String summary.codeModifyHandling.reflectionExplain.Book.privateStaticFinalVariable ::: value ::: privateStaticFinalVariable
// ::: path ::: private java.lang.String summary.codeModifyHandling.reflectionExplain.Book.privateVariable ::: value ::: privateVariable
// ::: path ::: public java.lang.String summary.codeModifyHandling.reflectionExplain.Book.publicVariable ::: value ::: publicVariable
// ::: path ::: protected java.lang.String summary.codeModifyHandling.reflectionExplain.Book.protectedVariable ::: value ::: protectedVariable
        System.out.println("----------------------------------");

        /**
         *  클래스의 필드 형태 조회 :::
         */
        System.out.println("::: 클래스의 필드 형태 검사 :::");
        Arrays.stream(Book.class.getDeclaredFields()).forEach(f -> {
            int modifiers = f.getModifiers();
            System.out.println(f);
            System.out.println("isPrivate :::" + Modifier.isPrivate(modifiers));
            System.out.println("isStatic ::: " + Modifier.isStatic(modifiers));
            System.out.println("isInstance ::: " + Modifier.isInterface(modifiers));
            System.out.println("isFinal ::: " + Modifier.isFinal(modifiers));
            System.out.println("isPublic ::: " + Modifier.isPublic(modifiers));
            System.out.println("isProtected ::: " + Modifier.isProtected(modifiers));
            System.out.println("isAbstract ::: " + Modifier.isAbstract(modifiers));
            System.out.println("----------------------------------");
        });

        System.out.println("====================================================================");

        /**
         * 클래스의 메서드 조회 :::
         * 상속받는 메서드도 호출된다.
         */
        System.out.println("::: 클래스의 메서드 호출 :::");
        Arrays.stream(Book.class.getMethods()).forEach(System.out::println);
        System.out.println("----------------------------------");

        /**
         * 클래스의 메서드 형태 조회 :::
         * 상속받는 메서드도 형태를 검사한다.
         */
        System.out.println("::: 클래스의 메서드 형태 검삭 :::");
        Arrays.stream(Book.class.getMethods()).forEach(m -> {
            int modifiers = m.getModifiers();
            System.out.println(m);
            System.out.println("isPrivate :::" + Modifier.isPrivate(modifiers));
            System.out.println("isStatic ::: " + Modifier.isStatic(modifiers));
            System.out.println("isInstance ::: " + Modifier.isInterface(modifiers));
            System.out.println("isFinal ::: " + Modifier.isFinal(modifiers));
            System.out.println("isPublic ::: " + Modifier.isPublic(modifiers));
            System.out.println("isProtected ::: " + Modifier.isProtected(modifiers));
            System.out.println("isAbstract ::: " + Modifier.isAbstract(modifiers));
            System.out.println("----------------------------------");
        });

        /**
         * 클래스의 메서드 파라미터 타입 조회
         * m.getParameterTypes() 값은 배열 형태로 반환한다.
         * -> 배열의 실제 값을 출력하기 위해서 Arrays.tostring(m.getParameterTypes()) 로 사용해서 출력
         */
        Arrays.stream(Book.class.getMethods()).forEach(m ->{
            System.out.println("::: MethodName = " + m.getName() + " ::: MethodParameterType = " + Arrays.toString(m.getParameterTypes()));
        });

        /**
         * 클래스의 메서드 반환 타입 조회
         */
        Arrays.stream(Book.class.getMethods()).forEach(m -> {
            System.out.println("::: MethodName = " + m.getName() + " ::: MethodReturnType = " + m.getReturnType());
        });



    }
}
