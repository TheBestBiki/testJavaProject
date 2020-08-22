package com.testClass;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2020/5/28
 */
public class TestClass extends Class2 {

    private String aa;


    //private SonnClass bb = new SonnClass();

    public void get(){
        SonnClass bb = new SonnClass();
        System.out.println(bb.getAaa());
    }



    public TestClass(){
        System.out.println("-主类构造函数");
    }

    {
        System.out.println("-主类代码块");
        SonnClass bb = new SonnClass();
        System.out.println(bb.getAaa());
    }

    public static void met(){
        System.out.println("-主类静态方法");
        SonnClass bb = new SonnClass();
        System.out.println(bb.getAaa());

    }



    private static class SonnClass{
        public SonnClass(){
            System.out.println("--内部类构造函数");
        }

        {
            System.out.println("--内部类代码块");
        }

        private static void sonnmet(){
            System.out.println("--内部类静态方法");
        }

        private String aaa="123";

        public String getAaa() {
            return aaa;
        }

        public void setAaa(String aaa) {
            this.aaa = aaa;
        }
    }


}


