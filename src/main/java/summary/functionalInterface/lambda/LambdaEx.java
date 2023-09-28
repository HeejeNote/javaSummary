package summary.functionalInterface.lambda;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class LambdaEx {
    public static void main(String[] args) {

        /**
         * 람다 표현식
         * (인자 리스트) -> {바디}
         *
         * 변수 캡쳐 (Variable Capture)
         *
         * 로컬 변수 캡쳐
         * - final이거나 effective final인 경우메나 참조할 수 있다.
         *
         * effective final
         * final 키워드를 사용하지 않은 변수를 익명 클래스 구현체 또는 람다에서 참조
         * -> 사실상 final로 간주되는 변수
         * -> 람다는 쉐도잉 X
         *
         * 쉐도잉이란 ?
         *
         *
         */


        LambdaEx lambdaEx = new LambdaEx();
//        lambdaEx.lambda();
        lambdaEx.lambdaAndLocalClassAndAnonymousClass();
    }

    private void lambda(){
        int baseNumber = 10;

        IntConsumer printInt = (i) -> {
            System.out.println(i + baseNumber);
        };

        printInt.accept(10);
    }

    private void lambdaVariableCapture(){
        int baseNumber = 10;

        /*
        IntConsumer printInt1 = (baseNumber) -> { // 람다의 scope은 lambdaVariableCapture() scope과 동일하다. => 같은 변수명 사용 X
            System.out.println(baseNumber);
        };
        */

        /*
        IntConsumer printInt2 = (i) -> {
            System.out.println(i + baseNumber); // 람다에서 참조하는 변수를 외부에서 값을 변경하려 하면 컴파일 에러가 발생한다.
        };

        printInt1.accept(10);
        printInt2.accept(10);

        baseNumber++;
        */
    }

    private void lambdaAndLocalClassAndAnonymousClass(){

        final int baseNumber = 10;

        // 로컬 클래스
        class LocalClass{
            void printBaseLocal(){
                System.out.println("local class ::: baseNumber ::: " + baseNumber);
            }
        }

        // 익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("anonymous Class baseNumber ::: " + baseNumber);
            }
        };

        // 람다
        IntConsumer printLambda = (i) -> {
            System.out.println("lambda i + baseNumber ::: " + (i + baseNumber) );
        };

        LocalClass lc = new LocalClass();
        lc.printBaseLocal();

        integerConsumer.accept(10);

        printLambda.accept(10);
    }



}
