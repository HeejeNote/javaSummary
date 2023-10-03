package summary.java8structure.concurrency.executors.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class threadPoolApp {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * CompletableFuture 는 스레드 풀을 생성 하지 않았는데 별도의 스레드로 동작이 되는지?
         * -> ForkJoinPool (DeQueue 방식 ::: 먼저 들어온게 나중에 나간다)
         * --> 자신의 스레드가 할 일이 없으면 디큐에서 할 일을 가져와서 처리를 하는 방식
         */

        /**
         * 스레드풀을 만들어서 비동기 처리도 가능
         */
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("::: Hello ::: " + Thread.currentThread().getName()); // pool-1-thread-1
            return "Hello";
        }, executorService).thenRun(() -> {
            System.out.println(Thread.currentThread().getName()); // pool-1-thread-1
        });

        voidCompletableFuture.get();
        executorService.shutdown();
        System.out.println("---------------------------------------------");

        // callback thread를 다른 thread로 실행시키려면 ? thenRunAsync 비동기 처리 함으로써 다른 스레드를 할당
        ExecutorService executorServiceAsync = Executors.newFixedThreadPool(4);
        CompletableFuture<Void> voidCompletableFutureAsync = CompletableFuture.supplyAsync(() -> {
            System.out.println("::: World ::: " + Thread.currentThread().getName()); // pool-2-thread-1
            return "World";
        }, executorServiceAsync).thenRunAsync(() -> {
            System.out.println(Thread.currentThread().getName()); // ForkJoinPool.commonPool-worker-1
        });

        voidCompletableFutureAsync.get();
        executorServiceAsync.shutdown();
        System.out.println("---------------------------------------------");

    }
}
