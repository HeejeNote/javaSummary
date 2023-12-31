package summary.java8structure.concurrency.executors.runnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        /**
         * Executors :::
         * 스레드를 만들고 관리한다.
         */

        /**
         * Single Thread
         */
        System.out.println("::: Executors.newSingleThreadExecutor() ::: ");
        ExecutorService singleThread = Executors.newSingleThreadExecutor(); // 하나의 스레드 Executors 객체 생성
        singleThread.submit(() -> System.out.println("Single Thread ::: " + Thread.currentThread().getName()));

        singleThread.shutdown(); // 현재 작업중인 작업을 마치고 스레드를 죽인다.
//        singleThread.shutdownNow(); // 현재 작업중인 작업과 상관없이 스레드를 죽인다.
        System.out.println("-----------------------------------------------");


        /**
         * Multi Thread
         * Executors.newFixedThreadPool(2) 스레드를 2개로 설정
         * -> task가 2개 이상이더라도 2개의 Thread만으로 task가 수행된다.
         */
        System.out.println("::: Executors.newFixedThreadPool(2) ::: ");
        ExecutorService multiThread = Executors.newFixedThreadPool(2); // 스레드 2개로 설정
        multiThread.submit(getRunnable("Hello ::: "));
        multiThread.submit(getRunnable("World ::: "));
        multiThread.submit(getRunnable("Thread ::: "));
        multiThread.submit(getRunnable("Executors ::: "));
        multiThread.shutdown();
        System.out.println("-----------------------------------------------");

        /**
         * Executors.newSingleThreadScheduledExecutor() :::
         * -> 싱글 스레드 스케줄 설정 
         * scheduleAtFixedRate(getRunnable("Schedule ::: "),1,2, TimeUnit.SECONDS)
         * -> 1초 후에 2초마다 스레드 호출
         */
        System.out.println("::: Executors.newSingleThreadScheduledExecutor() ::: ");
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(getRunnable("Schedule ::: "),1,2, TimeUnit.SECONDS);
        System.out.println("-----------------------------------------------");
    }

    private static Runnable getRunnable(String message) {
        return () -> System.out.println(message + Thread.currentThread().getName());
    }




}
