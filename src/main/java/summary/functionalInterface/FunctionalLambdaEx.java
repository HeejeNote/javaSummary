package summary.functionalInterface;

public class FunctionalLambdaEx {
    /**
     * 함수형 인터페이스 ::: 추상 메서드를 하나만 가지는 인터페이스. 다른 종류의 메서드의 종류의 갯수는 영향을 주지 않는다.
     * -> Single Abstract Method 인터페이스 // @FunctionalInterface 애노테이션을 가지고 있는 인터페이스
     *
     * 람다 표현식 ::: 함수형 인터페이스의 인스턴스를 만드는 방법으로 쓰일 수 있다.
     * -> 코드를 좀 더 간결하게. // 메소드 매개변수, 리턴 타입, 변수로 만들어 사용 할 수  있다.
     */
    public static void main(String[] args){

        /**
         * 익명 내부 클래스 anonymous inner class
         */
        FunctionalEx single = new FunctionalEx() {
            @Override
            public void doIt() {
                System.out.println("single anonymous inner class ::: heeje");
            }
        };

        /**
         * 위 코드를 람다식으로 변환
         * 메서드 내부 구현이 한줄이면 중괄호 없이 애로우 만으로 표현 가능
         */
        FunctionalEx singleLambda = () -> System.out.println("single lambda ::: heeje");



        /**
         * 익명 내부 클래스 anonymous inner class
         */
        FunctionalEx multiple = new FunctionalEx() {
            @Override
            public void doIt() {
                System.out.println("multiple anonymous inner class ::: heeje");
                System.out.println("multiple anonymous inner class ::: lambda");
            }
        };

        /**
         * 메서드 내부 구현이 여러 줄이면 중괄호 안으로 구현 코드를 묶어서 람다식으로 변환
         */
        FunctionalEx multipleLambda = () -> {
            System.out.println("multiple lambda ::: heeje");
            System.out.println("multiple lambda ::: lambda");
        };

        single.doIt();
        singleLambda.doIt();
        multiple.doIt();
        multipleLambda.doIt();

        /**
         * 순수 함수 ::: 결과가 외부 요인을 받지 않는 함수
         */
        PureFunctionEx pureFunctionEx = new PureFunctionEx() {
            @Override
            public int doIt(int number) {
                return number + 10;
            }
        };

        // 같은 입력 값을 넣으면 같은 결과를 출력하는 것을 보장한다.
        System.out.println("pureFunctionEx.doIt(1) = " + pureFunctionEx.doIt(1)); // 11
        System.out.println("pureFunctionEx.doIt(1) = " + pureFunctionEx.doIt(1)); // 11
        System.out.println("pureFunctionEx.doIt(1) = " + pureFunctionEx.doIt(1)); // 11


        /**
         * 비순수 함수 ::: 결과가 외부에 요인을 받는 함수
         * 아래 예시에서 변수값이 메서드 외부에서 선언되는 부분이 외부 요인을 받는다.
         */
        int baseNum = 10;
        PureFunctionEx disPure = new PureFunctionEx() {

            @Override
            public int doIt(int number) {
                return number + baseNum; // 함수 내에서 로컬 변수를 final 변수임을 가정하고 사용.

            }
        };

//        baseNum++; // 함수 내에서 참조한 변수를 외부에서 값을 변경할 수 없다.
        System.out.println("disPure.doIt(5) = " + disPure.doIt(5)); // 15

        /**
         * 비순수 함수 :::결과가 외부에 요인을 받는 함수
         * 아래 예시에서 변수값이 메서드 외부에서 선언되는 부분이 외부 요인을 받는다.
         *
         */
        PureFunctionEx disPure2 = new PureFunctionEx() {
            int baseNum2 = 10; // 외부에 상태값이 존재하게 되면 람다식으로 변환할 수 없다.
            @Override
            public int doIt(int number) {
                baseNum2++;
                return number + baseNum2;
            }
        };

        System.out.println("disPure2.doIt(5) = " + disPure2.doIt(5)); // 15
        System.out.println("disPure2.doIt(5) = " + disPure2.doIt(5)); // 16
        System.out.println("disPure2.doIt(5) = " + disPure2.doIt(5)); // 17
    }
}
