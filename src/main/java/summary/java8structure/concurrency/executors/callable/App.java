package summary.java8structure.concurrency.executors.callable;

import java.util.concurrent.*;

public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /**
         * Callable :::
         * Runnable과 유사하지만 void인 Runnable과 다르게 리턴값을 가질 수 있다.
         */

        // get()
        ExecutorService executorsGet = Executors.newSingleThreadExecutor();
        Callable<String> helloGet = () -> {
            Thread.sleep(2000L);
            return "HelloGet";
        };

        Future<String> helloFutureGet = executorsGet.submit(helloGet);
        System.out.println(helloFutureGet.isDone()); // isDone() ::: 작업상태 확인 boolean type
        System.out.println("::: HelloGet Started :::");

        helloFutureGet.get(); // 블로킹 : get()을 하는 순간 결과가 나올 떄까지 기다린다.

        System.out.println(helloFutureGet.isDone());
        System.out.println("::: HelloGet End :::");
        executorsGet.shutdown();

        // cancel()
        ExecutorService executorsCancel = Executors.newSingleThreadExecutor();
        Callable<String> helloCancel = () -> {
            Thread.sleep(2000L);
            return "HelloCancel";
        };

        Future<String> helloFutureCancel = executorsCancel.submit(helloCancel);

        System.out.println(helloFutureCancel.isDone()); // isDone() ::: 작업상태 확인 boolean type
        System.out.println("::: helloFutureCancel Started :::");

        helloFutureCancel.cancel(false); // cancel(false) ::: 작업 상태를 취소한다.
        //helloFutureCancel.get(); // 작업을 취소하고 get()을 하면 에러가 발생 -> java.util.concurrent.CancellationException
        System.out.println(helloFutureCancel.isDone());
        System.out.println("::: helloFutureCancel End :::");
        executorsCancel.shutdown();

    }
}
