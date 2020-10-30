package com.Thread;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2020/10/21
 */
public class MyThread extends Thread {

    public MyThread(){
        System.out.println("当前线程的名字："+Thread.currentThread().getName());
        System.out.println("当前线程的名字："+this.getName());
    }

    @Override
    public void run(){
        System.out.println("当前线程的名字："+Thread.currentThread().getName()+"   run=="+Thread.currentThread().isAlive());
        System.out.println("当前线程的名字："+this.getName()+"  run=="+this.isAlive());
    }

    public static void main(String[] args) {
        testCurrentThread();

    }

    /**
     * 测试Thread.currentThread跟this的区别
     * 参考网址：https://blog.csdn.net/dfshsdr/article/details/92760135
     *
     * Thread.currentThread表示当前代码段正在被哪个线程调用的相关信息。
     * this表示的是当前对象，与Thread.currentThread有很大的区别。
     */
    private static void testCurrentThread() {
        MyThread myThread=new MyThread();
        //myThread.start(); 直接启动会触发run方法的执行，这里run方法里2个打印的名称是一样的

        //初始化Thread对象，方便调用start();
        //此时myThread作为参数传入Thread中，其实是myThread委托thread去执行；
        Thread thread=new Thread(myThread);
        //初始化自定义线程名称
        thread.setName("C");// 因为
        //myThread.setName("CC");
        //启动线程
        thread.start();
    }

}
