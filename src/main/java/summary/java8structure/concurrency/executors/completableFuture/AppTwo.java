package summary.java8structure.concurrency.executors.completableFuture;

import java.io.UncheckedIOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;


public class AppTwo {
    /**
     * 조합하기
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * allOf() :::
         * 여러 작업을 모두 실행하고 모든 작업 결과에 콜백 실행
         */
        System.out.println("-----------------------------------------");

        System.out.println("::: allOf() :::");
        CompletableFuture<String> workOne = CompletableFuture.supplyAsync(() -> {
            System.out.println("WorkOne ::: " + Thread.currentThread().getName());
            return "WorkOne";
        });

        CompletableFuture<String> workTwo = CompletableFuture.supplyAsync(() -> {
            System.out.println("WorkTwo ::: " + Thread.currentThread().getName());
            return "WorkTwo";
        });

        List<CompletableFuture<String>> futures = Arrays.asList(workOne, workTwo);
        CompletableFuture[] futuresArray = futures.toArray(new CompletableFuture[futures.size()]);

        CompletableFuture<List<String>> results = CompletableFuture.allOf(futuresArray)
                .thenApply(v -> futures.stream()
                        .map(CompletableFuture::join) // join : get 과 같은 기능 -> 에러시 UncheckedIOException 발생시킨다.
                        .collect(Collectors.toList())); // join에서 결과값이 나온걸 list로 만든다.

        results.get().forEach(System.out::println);
        System.out.println("-----------------------------------------");


        /**
         * anyOf() :::
         * 여러 작업 중에 가장 빨리 끝난 하나의 결과에 콜백 실행
         */
        System.out.println("::: anyOf() :::");

        CompletableFuture<String> anyOne = CompletableFuture.supplyAsync(() -> {
            System.out.println("WorkOne ::: " + Thread.currentThread().getName());
            return "AnyOne";
        });

        CompletableFuture<String> anyTwo = CompletableFuture.supplyAsync(() -> {
            System.out.println("WorkTwo ::: " + Thread.currentThread().getName());
            return "AnyTwo";
        });

        CompletableFuture<Void> thenAccept = CompletableFuture.anyOf(anyOne, anyTwo).thenAccept(System.out::println);
        thenAccept.get();
        System.out.println("-----------------------------------------");
        /**
         * thenCombine() :::
         * 두 작업을 독립적으로 실행하고 둘 다 종료 했을 때 콜백 실행
         */
        System.out.println("::: thenCombine() :::");
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println("::: Hello ::: " + Thread.currentThread().getName());
            return "Hello";
        });

        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
            System.out.println("::: World ::: " + Thread.currentThread().getName());
            return "World";
        });

        CompletableFuture<String> helloWorld = hello.thenCombine(world, (h, w ) -> h + " " + w);
        System.out.println(helloWorld.get());
        System.out.println("-----------------------------------------");

        /**
         * thenCompose() :::
         * 두 작업이 서로 이어서 실행하도록 조합
         */
        System.out.println("::: thenCompose() :::");
        CompletableFuture<String> spring = CompletableFuture.supplyAsync(() -> {
            System.out.println("::: Spring :::" + Thread.currentThread().getName()); // ::: Spring :::ForkJoinPool.commonPool-worker-1
            return "Spring";
        });

        CompletableFuture<String> springBoot = spring.thenCompose(AppTwo::getBoot);
        System.out.println(springBoot.get()); // Spring Boot
    }

    private static CompletableFuture<String> getBoot(String message) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("::: Boot :::" + Thread.currentThread().getName()); // ::: Boot :::ForkJoinPool.commonPool-worker-1
            return message + " Boot";
        });
    }
}
