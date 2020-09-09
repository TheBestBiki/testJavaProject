package com.exception;

import java.util.List;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2020/7/23
 */
public class TestException {

    public static void main(String[] args) {
        //testManyCatch();
        TestExceptionGetMessage();

    }

    /**
     * 测试打印 e 跟打印 e.getMessage的区别
     *
     * 结果：多用e.toString   e.getMessage打印的信息没有前者具体
     */
    private static void TestExceptionGetMessage() {
        try{
            String aa=null;
            aa.equals(1);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * 测试多个 catch
     * 结果： 抛出一个catch的异常后，后面的catch就不会再执行
     */
    private static void testManyCatch() {
        try{
            List<String> aa = null;
            aa.size();
        }catch (NullPointerException e1){
            System.out.println("e1---");
            throw e1;
        }catch (Exception e2){
            System.out.println("e2---");
            throw e2;
        }
    }
}
