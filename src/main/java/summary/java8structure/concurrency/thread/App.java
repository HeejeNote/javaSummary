package summary.java8structure.concurrency.thread;

public class App {
    public static void main(String[] args) {

        /**
         * 람다로 만드는 방법
         */
        Thread lambdaThread = new Thread(() -> { // Runnable이 함수형 인터페이스이므로 람다식으로 변환이 가능
            System.out.println("Lambde적용 Thread ::: " + Thread.currentThread().getName());
        });
        lambdaThread.start();


        /**
         * Runnable 구현으로 만드는 방법
         */
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runuuable ::: " + Thread.currentThread().getName());
            }
        });
        thread.start();


        /**
         * Thread를 상속받아서 만드는 방법
         */
        MyThread myThread = new MyThread();
        myThread.start();

        System.out.println("Hello");

    }

    static class MyThread extends  Thread{
        @Override
        public void run() {
            System.out.println("Thread ::: " + Thread.currentThread().getName());
        }
    }
}
