package com.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2020/12/11
 */
public class FutureTest {

    public static void main(String[] args) {
        FutureTest futureTest = new FutureTest();
        futureTest.testCompletableFutureSupplyAsync();
    }

    /**
     * 参考文章：https://blog.csdn.net/wangdong5678999/article/details/81842511
     */
    private  void testCompletableFutureSupplyAsync() {
        Future<Double> priceAsync1 = getPriceAsync1("11");
        Future<Double> priceAsync2 = getPriceAsync2("22");
    }

    /**
     * 传统的写法
     * @param product
     * @return
     */
    public Future<Double> getPriceAsync1(String product) {
        //创建CompletableFuture 对象，它会包含计算的结果
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        //在另一个线程中以异步方式执行计算
        new Thread(() -> {
            double price = calculatePrice(product);
            //需长时间计算的任务结 束并得出结果时，设置 Future的返回值
            futurePrice.complete(price);
        }).start();
        // 无需等待还没结束的计算，直接返回Future对象
        return futurePrice;
    }

    /**
     * 新写法 工厂方法创建CompletableFuture     lambda表达式简写
     * supplyAsync方法接受一个生产者(Supplier)作为参数，返回一个CompletableFuture对象，该对象完成异步执行后会读取调用生产者方法的返回值。
     * 生产者方法会交由ForkJoinPool 池中的某个执行线程(Executor)运行
     * 但是你也可以使用supplyAsync方法的重载版本，传 递第二个参数指定不同的执行线程执行生产者方法
     * @param product
     * @return
     */
    public Future<Double> getPriceAsync2(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    private double calculatePrice(String product) {
        return 1;
    }

}
