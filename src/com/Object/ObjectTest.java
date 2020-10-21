package com.Object;

import com.stream.TestClass;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2020/10/10
 */
public class ObjectTest {

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        Integer a = test1(testClass);
        Integer b = test2(testClass);
        System.out.println(testClass.toString());
    }

    private static Integer test2(TestClass testClass) {
        testClass.setPro1("11");
        return 1;
    }

    private static Integer test1(TestClass testClass) {
        testClass.setPro2("222");
        return 2;
    }


}
