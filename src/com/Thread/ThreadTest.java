package com.Thread;

import java.util.concurrent.*;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2020/10/9
 */
public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        //testThreadForParameter();
        //testThreadJoin();
        testExecutorPool();
        //testSynBlockingQueue();
    }

    private static void testSynBlockingQueue() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new SynchronousQueue<>(true));
        for (int i = 1; i < 5; i++) {
            final Integer j = i;

            //Thread.sleep(10);
            System.out.println("第"+i+"个头");
            threadPoolExecutor.submit(()->{
               /* try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                System.out.println("第"+j+"个内");
                System.out.println("第"+j+"个尾");

            });
        }

    }

    /**
     * 创建线程池，用这种最基本的构造方法来创建
     * 不用工具类创建是因为，不够灵活，容易存在浪费的线程池
     *
     * 若要实现线程池里的任务先进先出，如果用的队列是ArrayBlockingQueue或者LinkedBlockingDeque的话，则corePoolSize要足够大，至少要满足当前系统的最大任务数
     * 若用的是SynchronousQueue,则maximumPoolSize要足够大，至少要满足当前系统的最大任务数
     *
     * 若线程池的核心线程池不为0，则这个程序不会停止，也一直处于启动状态；当核心线程池为0时，程序才会停止
     * 如下代码，当队列使用的是ArrayBlockingQueue，且容量指定为1时
     * 当核心线程数都处于执行中，而队列里也满了，这时，还不会创建非核心线程
     * 当核心线程都忙，且队列也满了。这个时候，如果又来了一个新任务，则会创建一个非核心线程，来处理这个<新任务>，而不是之前队列里排了很久的旧任务。
     * 若此时新任务执行完了，核心线程的任务还没执行完，则队列里的旧任务，会交由该非核心线程来执行。
     * 结果：先打印"第三个"，然后"第二个"，最后"第一个"。
     * 若继续在代码里加第四个任务，则会报错，因为核心线程，非核心线程都在忙，队列又满了，此时新任务进来，就会被拒绝
     * 解决办法是，将这个被拒的消息，进行持久化储存。等线程池不那么忙时，再解决这些任务
     * 参考网址：https://blog.csdn.net/fengye454545/article/details/79536986
     */
    private static void testExecutorPool() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(1));
        threadPoolExecutor.submit(()->{
            try {
                Thread.sleep(4000L);
                System.out.println(Thread.currentThread().getName()+"第一个");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadPoolExecutor.submit(()->{
            System.out.println(Thread.currentThread().getName()+"第二个");
        });
        threadPoolExecutor.submit(()->{
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"第三个");
        });

    }

    // 网址参考：https://blog.csdn.net/wangdong5678999/article/details/81842528
    // 创建一个线程池，线程池中线程的数目为100 和商店数目 二者中较小 的一个值
    private final Executor executor = Executors.newFixedThreadPool(50, new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            //使用守护线程——这种方式不会阻止程序的关停
            t.setDaemon(true);
            return t;
        }
    });

    /**
     * 测试线程的join方法的执行顺序
     * 结果： 线程thread一旦start，就立马开始执行,不受join的影响
     *        线程join,会使当前线程处于等待状态，也就是说，join之后的代码，得等join所属的线程执行完了，才能开始执行
     *        【可以把join看成是一个判断】，如果join所属的线程执行完了，那么下一行代码才会执行
     *         比如本方法中，虽然 thread1跟 thread2一起start了，但是因为 打印“主线程3”的前面，只有thread1的join
     *         所以只要thread1执行完了，不管thread2有没有执行完，“主线程3”都会被打印出来
     *
     *         而打印 “主线程4”的前面，有thread2跟thread3的join
     *         所以打印 “主线程4”的条件是，thread2跟thread3所属的线程都执行完毕了，才会执行，即打印 “主线程4”
     *
     *         thread3是在thread2的join之后才start，所以thread3只能在thread2这个线程执行完后，才会启动
     */
    private static void testThreadJoin() throws InterruptedException {
        System.out.println("主线程1");
        Thread thread1 = new Thread(()->{
            sleep2();//自定义方法，睡眠2秒
            System.out.println("子线程1");
        });
        System.out.println("主线程2");
        Thread thread2 = new Thread(()->{
            sleep4();//自定义方法，睡眠4秒
            sleep2();//自定义方法，睡眠2秒
            System.out.println("子线程2");
        });
        Thread thread3 = new Thread(()->{
            sleep2();//自定义方法，睡眠2秒
            System.out.println("子线程3");
        });
        thread1.start();
        thread2.start();
        thread1.join();
        System.out.println("主线程3");
        thread2.join();
        thread3.start();
        thread3.join();


        System.out.println("主线程4");
    }

    /**
     * 当前线程睡眠1秒
     */
    private static void sleep1() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 当前线程睡眠2秒
     */
    private static void sleep2() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 当前线程睡眠4秒
     */
    private static void sleep4() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试新发起一个线程时，能不能调用方法内的或者全局变量作为入参
     * 结果：可以
     */
    private static void testThreadForParameter() {
        int a = 1;
        int b = 2;
        new Thread(()->test(a,b)).start();
        System.out.println("end");
    }

    private static void test(int a, int b) {
        System.out.println(a+"--"+b);
    }


}
