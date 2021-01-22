package com.Thread;

import java.util.concurrent.*;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2021/1/22
 */
public class CompletableFutureTest2 {

    private static ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        testAsync();
    }

    /**
     * 函数式接口Supplier 与 Function的区别：
     *     Supplier不用传入参，即一定要写成 ()-> 返回值   这种形式
     *     Function要传入参，即 (入参)-> 返回值
     */

    /**
     * CompletableFuture.supplyAsync(() -> 1 , executorService)
     * 这里可以这样写是因为，本身该方法有2个参数 CompletableFuture<U> supplyAsync(Supplier<U> supplier,Executor executor)
     * ()->1 ,其实就是函数式接口 Supplier<U> supplier 的简写
     * 所以其实可以看成是传入了2个参数，CompletableFuture.supplyAsync( (() -> 1) , executorService)
     */
    private static void testAsync() {
        CompletableFuture<Integer> stringCompletableFuture = CompletableFuture.supplyAsync(() -> 1 ).thenApply(i -> i + 1);
        CompletableFuture<Integer> stringCompletableFuture2 = CompletableFuture.supplyAsync(() -> 1 , executorService).thenApply(i -> i + 2);
        //Integer join = stringCompletableFuture.join();
        //Integer join2 = stringCompletableFuture2.join();
        //System.out.println(join);

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(stringCompletableFuture, stringCompletableFuture2);
        voidCompletableFuture.join();
        //voidCompletableFuture.thenApply(() -> "1");
    }

}
