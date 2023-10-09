package summary.codeModifyHandling.reflectionApi.reflectionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        /**
         * Default 생성자 호출 :::
         */
        Class<?> musicClass = Class.forName("summary.codeModifyHandling.reflectionApi.reflectionControl.Music");
        Constructor<?> constructor = musicClass.getConstructor();
        Music myMusic = (Music) constructor.newInstance();
        System.out.println("myMusic = " + myMusic);
        //  ::: defaultConstructor :::
        // myMusic = summary.codeModifyHandling.reflectionApi.reflectionControl.Music@f6f4d33

        /**
         * 생성자 인자 넘겨서 호출 :::
         * -> 인자 하나를 넘기므로 클래스에 파라미터 하나를 받는 생성자가 정의되어 있어야 한다.
         */
        Class<?> musicClass2 = Class.forName("summary.codeModifyHandling.reflectionApi.reflectionControl.Music");
        Constructor<?> constructor2 = musicClass2.getConstructor(String.class);
        Music myMusic2 = (Music) constructor2.newInstance("oneParameter");
        System.out.println("myMusic2 = " + myMusic2);
        // myMusic2 = summary.codeModifyHandling.reflectionApi.reflectionControl.Music@23fc625e

        /**
         * static 필드값 호출 :::
         */
        Field staticField = Music.class.getDeclaredField("staticField");
        System.out.println("staticField = " + staticField.get(null)); // staticFieldValue


        /**
         * static 필드값 변경 :::
         */
        Field staticField2 = Music.class.getDeclaredField("staticField");
        System.out.println("set Before staticField2 = " + staticField2.get(null)); // staticFieldValue
        staticField.set(null,"Edit staticField"); // set(Object o , Object value) // static 이므로 특정 인스턴스를 사용하지 않으므로 첫번째 인자값은 null
        System.out.println("set After staticField2 = " + staticField2.get(null)); // Edit staticField

        /**
         * 특정 인스턴스에 해당하는 필드값 호출 :::
         */
        Class<?> musicClass3 = Class.forName("summary.codeModifyHandling.reflectionApi.reflectionControl.Music");
        Constructor<?> constructor3 = musicClass3.getConstructor();

        Music myMusic3 = (Music) constructor3.newInstance();

        Field privateField = Music.class.getDeclaredField("instanceField"); // 인스턴스 필드를 호출하려면 객체를 인스턴스화하여 필드를 호출해야 한다.
        privateField.setAccessible(true); // 접근 제어자 무시하고 접근 허용
        System.out.println("privateField.get(String.class) = " + privateField.get(myMusic3)); // instanceFieldValue

        /**
         * 특정 인스턴스 해당하는 필드값 변경 :::
         */
        privateField.set(myMusic3,"set instanceField");
        System.out.println("privateField.get(myMusic3) = " + privateField.get(myMusic3)); // set instanceField

        /**
         * 인스턴스 메서드 호출 :::
         */
        Method privateVoidMethod = Music.class.getDeclaredMethod("privateVoidMethod");
        privateVoidMethod.setAccessible(true); // 메서드 접근제어자 무시하고 접근
        privateVoidMethod.invoke(myMusic3); // ::: private void Method :::

        /**
         * 인스턴스 메서드 호출 :::
         * -> 파라미터 존재하는 메서드
         */
        Method sum = Music.class.getDeclaredMethod("sum", int.class, int.class);
        int invoke =(int) sum.invoke(myMusic3, 5, 7);
        System.out.println("invoke = " + invoke); // 12
    }
}
