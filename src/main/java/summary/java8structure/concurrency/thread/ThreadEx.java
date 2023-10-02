package summary.java8structure.concurrency.thread;

public class ThreadEx {
    public static void main(String[] args) throws InterruptedException {
        /**
         * 현재 쓰레드 멈춰두기 ::: sleep
         */
        Thread threadSleep = new Thread(() -> {
                try {
                    Thread.sleep(1000L); // Thread를 1초동안 멈춘다.
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            System.out.println("Thread ::: " + Thread.currentThread().getName());
        });

        threadSleep.start();

        System.out.println("Hello ::: " + Thread.currentThread().getName());
        System.out.println("------------------------------------------------");

        /**
         * 다른 쓰레드 깨우기 ::: interupt
         */
        Thread threadInterupt = new Thread(() -> {
            while(true){
                System.out.println("Thread ::: " + Thread.currentThread().getName());
                try{
                    Thread.sleep(1000L);
                }catch(InterruptedException e){
                    System.out.println("::: exit :::");
                    return;
                }
            }
        });
        threadInterupt.start();

        System.out.println("HelloInterupt = " + Thread.currentThread().getName());
        Thread.sleep(3000L);
        threadInterupt.interrupt(); // interrupt()는 catch로 잡아서 쓰레드를 깨운다.


        /**
         * 다른 쓰레드 기다리기 ::: join
         */
        Thread threadJoin = new Thread(() -> {
            System.out.println("Thread ::: " + Thread.currentThread().getName());
            try{
                Thread.sleep(3000l);
            }catch(InterruptedException e){
                throw new IllegalStateException(e);
            }
        });
        threadJoin.start();

        System.out.println("Hello ::: " + Thread.currentThread().getName());
        threadJoin.join(); // Thread.sleep(3000l); 끝날때 까지 기다렸다가 아래 코드가 실행된다.
        System.out.println(threadJoin + " is finished");

        /**
         * join 중에 interrupt 발생하는 경우
         */
//        try {
//            threadJoin.join();
//            // join으로 기다리는 와중에 다른 스레드에서 interrupt 하면 catch에서 에러가 발생한다.
//            // -> 스레드를 일률적으로 관리하는 방법은 적절하지 않음
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        threadInterupt.interrupt();


    }
}
