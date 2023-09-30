package summary.java8structure.functional;

import java.util.function.Function;

public class PlusNumber implements Function<Integer, Integer> {

    /**
     * Function<Integer, Integer> // 첫번쨰 파라미터 - 입력값 타입 , 두번째 파라미터 - 반환값 타입
     */

    @Override
    public Integer apply(Integer integer) {
        return integer + 10;
    }
}
