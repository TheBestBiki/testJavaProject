package com.Thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2021/1/8
 */
public class CompletableFutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFutureTest completableFutureTest = new CompletableFutureTest();
        completableFutureTest.method();
    }


    private void method() throws ExecutionException, InterruptedException {


        /*f1.whenCompleteAsync(new BiConsumer<String, Throwable>() {
            @Override
            public void accept(String s, Throwable throwable) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(System.currentTimeMillis() + ":f1-Complete停止了2秒" );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ":" + s);
            }
        });*/

        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(System.currentTimeMillis() + ":f2停止了2秒" );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "f2";
        });

        f2.whenCompleteAsync(new BiConsumer<String, Throwable>() {
            @Override
            public void accept(String s, Throwable throwable) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(System.currentTimeMillis() + ":f2-Complete停止了2秒" );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ":" + s);
            }
        });

        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(System.currentTimeMillis() + ":f1停止了3秒" );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "f1";
        }).whenCompleteAsync(new BiConsumer<String, Throwable>() {
            @Override
            public void accept(String s, Throwable throwable) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(System.currentTimeMillis() + ":f1-Complete停止了2秒" );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ":" + s);
            }
        }).thenApplyAsync(s->{
            System.out.println("自定义"+s);
            return s;
        });

        CompletableFuture<Void> all = CompletableFuture.allOf(f1, f2);

        //阻塞，直到所有任务结束。
        System.out.println(System.currentTimeMillis() + ":阻塞");
        all.join();
        System.out.println(System.currentTimeMillis() + ":阻塞结束");

        //一个需要耗时2秒，一个需要耗时3秒，只有当最长的耗时3秒的完成后，才会结束。
        System.out.println("任务均已完成。");
    }

}
