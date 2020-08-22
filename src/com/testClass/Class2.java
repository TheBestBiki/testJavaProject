package com.testClass;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2020/5/29
 */
public class Class2 {

    public Class2(){
        System.out.println("父类构造函数--无参");
    }

    public Class2(String aa){
        System.out.println("父类构造函数");
    }

    {
        System.out.println("父类代码块");
    }
}
