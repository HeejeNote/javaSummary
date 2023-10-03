package summary.java8structure.concurrency.executors.completableFuture;

import java.util.concurrent.*;

public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * CompletableFuture :::
         * 자바에서 비동기(Asynchronous) 프로그래밍을 가능케하는 인터페이스
         * completedFuture  => 정적 팩토리 메서드
         * -> 정적 팩토리 메서드로 이미 완료된 결과를 가지는 CompletableFuture 객체를 생성한다.
         */
        System.out.println("::: completedFuture :::");
        CompletableFuture<String> heeje = CompletableFuture.completedFuture("heeje");
        System.out.println("heeje ::: " + heeje.get()); // heeje
        System.out.println("-------------------------------------------------");

        /**
         * 비동기 처리
         * 리턴값이 없는 경우 ::: runAsync()
         * 리턴값이 있는 경우 ::: supplyAsync()
         */
        System.out.println("::: CompletableFuture Async :::");
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(" stringCompletableFuture = " + Thread.currentThread().getName()); //  ForkJoinPool.commonPool-worker-1
            return "Java";
        });
        System.out.println("  stringCompletableFuture.get() = " + stringCompletableFuture.get()); // Java
        System.out.println("-------------------------------------------------");
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            System.out.println(" voidCompletableFuture = " + Thread.currentThread().getName()); //  ForkJoinPool.commonPool-worker-1
        });
        System.out.println("  voidCompletableFuture.get() = " + voidCompletableFuture.get()); // null
        System.out.println("-------------------------------------------------");

        /**
         * 콜백 처리
         * thenApply(Function) ::: 리턴값을 받아서 콜백 함수에서 처리 후에 값을 리턴
         * thenAccept(Consumer) ::: 리턴값을 받아서 콜백 함수에서 처리(콜백함수 ==> 컨슈머 리턴 없음)
         * thenRun(Runnable) ::: 리턴값을 참조 상관 없이 콜백함수로 다른 작업을 처리하는 콜백
         */
        System.out.println("::: CompletableFuture CallBack :::");

        CompletableFuture<String> thenApplyFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("::: Call -> thenApply ::: " + Thread.currentThread().getName()); // ForkJoinPool.commonPool-worker-1
            return "thenApply";
        }).thenApply((s) -> { // 기존에 future만 사용했을때는 get() 호출전에 콜백 처리가 불가능했다.
            System.out.println(Thread.currentThread().getName());
            return s.toUpperCase();
        });
        // get()을 호출해야 콜백 값을 받아온다.
        System.out.println("thenApplyFuture.get() = " + thenApplyFuture.get()); // THENAAPLY
        System.out.println("-------------------------------------------------");

        CompletableFuture<Void> thenAcceptFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("::: Call -> thenAccept ::: " + Thread.currentThread().getName()); // ForkJoinPool.commonPool-worker-1
            return "thenAccept";
        }).thenAccept((s) -> {
            System.out.println(Thread.currentThread().getName());
        });

        System.out.println("thenAcceptFuture.get() = " + thenAcceptFuture.get()); // null
        System.out.println("-------------------------------------------------");

        CompletableFuture<Void> thenRunFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("::: Call -> thenRun ::: " + Thread.currentThread().getName()); // ForkJoinPool.commonPool-worker-1
            return "thenRun";
        }).thenRun(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        System.out.println("thenRunFuture.get() = " + thenRunFuture.get());
        System.out.println("-------------------------------------------------"); // null
    }

}
