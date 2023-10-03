package summary.java8structure.concurrency.executors.completableFuture;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ExceptionApp {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * exceptionally(에러)
         * 예외처리
         */
        boolean throwError = true;

        CompletableFuture<String> exceptionally = CompletableFuture.supplyAsync(() -> {
            if (throwError) { // true이면 에러를 발생시킨다.
                throw new IllegalStateException();
            }

            System.out.println("::: Hello ::: " + Thread.currentThread().getName());
            return "Hello";

        }).exceptionally(e -> { // exceptionally : 에러 타입을 받아서 리턴할 수 있다.
            System.out.println("e = " + e);
            return "Error";
        });

        System.out.println(exceptionally.get());

        System.out.println("-----------------------------------");
        /**
         * handle(결과값,에러)
         * 예외처리
         */
        CompletableFuture<Serializable> handle = CompletableFuture.supplyAsync(() -> {
            if (throwError) {
                throw new IllegalStateException();
            }

            System.out.println("::: World ::: " + Thread.currentThread().getName());
            return "World";

        }).handle((result, e) -> {
            if (e != null) {
                System.out.println("e = " + e);
                return "Error";
            }
            return result;
        });
        System.out.println(handle.get());

    }
}
