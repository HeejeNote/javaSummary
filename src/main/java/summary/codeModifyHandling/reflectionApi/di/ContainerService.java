package summary.codeModifyHandling.reflectionApi.di;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ContainerService {

    /**
     * DI 필드주입 방식 :::
     * @param classType
     * @return
     * @param <T>
     */
    public static <T> T getObject(Class<T> classType){ // Class 타입으로 파라미터를 받으면 인스턴스를 반환하도록
        T instance = createInstance(classType);
        Arrays.stream(classType.getDeclaredFields()).forEach(f -> {
            if(f.getAnnotation(Inject.class) != null){
                Object fieldInstance = createInstance(f.getType()); // f.getType() -> 여기서는 BookRepository type이기에 인스턴스가 필요하다.
                f.setAccessible(true); // private의 경우가 있으므로 접근제어 허용으로 변경
                try {
                    f.set(instance, fieldInstance); // 필드값 변경
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        return instance;
    }

    private static <T> T createInstance(Class<T> classType) {
        try {
            return classType.getConstructor(null).newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

}


