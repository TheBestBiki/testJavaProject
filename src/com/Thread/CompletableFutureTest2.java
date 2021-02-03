package com.Thread;

import java.util.concurrent.*;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2021/1/22
 */
public class CompletableFutureTest2 {

    private static ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        testAsync();
    }

    /**
     * 函数式接口Supplier 与 Function的区别：
     *     Supplier不用传入参，即一定要写成 ()-> 返回值   这种形式
     *     Function要传入参，即 (入参)-> 返回值
     *     Runnable不需要传入参，也没有返回结果
     */

    /**
     * CompletableFuture未简化写法的参考网址：https://blog.csdn.net/weixin_34043301/article/details/89689502
     * CompletableFuture.supplyAsync(() -> 1 , executorService)
     * 这里可以这样写是因为，本身该方法有2个参数 CompletableFuture<U> supplyAsync(Supplier<U> supplier,Executor executor)
     * ()->1 ,其实就是函数式接口 Supplier<U> supplier 的简写
     * 所以其实可以看成是传入了2个参数，CompletableFuture.supplyAsync( (() -> 1) , executorService)
     *
     * 若依赖异步线程里的处理结果，用CompletableFuture.supplyAsync
     * 若不依赖或者不需要异步线程返回结果，用CompletableFuture.runAsync
     *
     * 若有多个thenApply，则每个thenApply的返回值类型不需要一样，具体可见future3及future4
     */
    private static void testAsync() throws ExecutionException, InterruptedException, TimeoutException {
        /*CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 1 ).thenApply(i -> i + 1); // 结果为2
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 1 , executorService).thenApply(i -> i + 2); // 结果为3
        CompletableFuture<Integer> future3 = CompletableFuture.runAsync(() -> System.out.println("111") , executorService).thenApply(i -> 1).thenApply(i->i+3); // 结果为4
        CompletableFuture<Integer> future4 = CompletableFuture.runAsync(() -> System.out.println("222") , executorService).thenApply(i -> "1").thenApply(i->Integer.valueOf(i)+3); // 结果为4
        // exceptionally
        CompletableFuture<Void> future5 = CompletableFuture.runAsync(() -> { Integer a = null; a.toString();} , executorService)
                .exceptionally((e)->{
                    System.out.println(e.toString());
                    return null;
                });
        CompletableFuture<Integer> future6 = CompletableFuture.runAsync(() -> { Integer a = null; a.toString();} , executorService)
                .thenApply(i -> 1) // future6跟future5相比多了这个thenApply,thenApply返回的值要跟CompletableFuture的泛型一样
                .exceptionally((e)->{
                    System.out.println(e.toString());
                    return 1; // 返回值要跟CompletableFuture的泛型对应，泛型为Void,就只能返回null
                });*/

        CompletableFuture<Integer> future7 = CompletableFuture.supplyAsync(() -> {System.out.println(Thread.currentThread().getName()+"-777");return 77;})
                .whenComplete((v,e)->{ // 回归主线程
                    System.out.println(Thread.currentThread().getName()+"---"+v);
                });
        CompletableFuture<Integer> future8 = CompletableFuture.supplyAsync(() -> {System.out.println(Thread.currentThread().getName()+"-888");return 88;}) // 用的CompletableFuture内置默认的线程池
                .whenCompleteAsync((v,e)->{ // 不管前面有没有用到自定义的线程池，这里都是用的CompletableFuture内置默认的线程池
                    System.out.println(Thread.currentThread().getName()+"---"+v);
                });
        CompletableFuture<Integer> future9 = CompletableFuture.supplyAsync(() -> {System.out.println(Thread.currentThread().getName()+"-999");return 99;}, executorService) // 用的自定义的线程池
                .whenCompleteAsync((v,e)->{ // 不管前面有没有用到自定义的线程池，这里都是用的CompletableFuture内置默认的线程池
                    System.out.println(Thread.currentThread().getName()+"---"+v);
                });
        //System.out.println(future7.get());



        /*System.out.println(future1.join());// 获取future1执行完后的返回值
        System.out.println(future2.get()); // 获取future1执行完后的返回值,若不返回，则一直等待。可对get方法的入参设置值来控制等待的时间
        System.out.println(future3.get(5,TimeUnit.MILLISECONDS));
        System.out.println(future4.get());
        System.out.println(future5.get());*/

        /*CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(future1, future2);
        voidCompletableFuture.join();
        voidCompletableFuture.thenApply(i->2);*/
    }

}
