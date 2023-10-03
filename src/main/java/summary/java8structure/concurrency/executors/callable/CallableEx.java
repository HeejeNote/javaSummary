package summary.java8structure.concurrency.executors.callable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CallableEx {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        /**
         * Callable 여러개 사용
         */
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Callable<String> java = () -> {
            Thread.sleep(2000L);
            return "Java";
        };

        Callable<String> spring = () -> {
            Thread.sleep(3000L);
            return "Spring";
        };

        Callable<String> boot = () -> {
            Thread.sleep(1000L);
            return "Boot";
        };

        /**
         * invokeAll
         * -> java, spring, boot 전부 기다린다.
         */
        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(java, spring, boot));
        for(Future<String> f : futures){
            System.out.println(f.get());
            // 모든 작업을 기다린 후에 리스트에 담긴 스레드를 호출 ::: 전부 기다린 후에 리스트에 담기므로 담긴 순서대로 호출된다.
        }

        /**
         * invokeAny
         * -> Blocking call
         * -> call 타입으로 바로 호출 결과가 나온다.
         */
        String s = executorService.invokeAny(Arrays.asList(java, spring, boot));
        System.out.println("s = " + s); // 가장 작업이 빨리 종료되는 스레드 호출 ::: Boot
        executorService.shutdown();
    }
}
