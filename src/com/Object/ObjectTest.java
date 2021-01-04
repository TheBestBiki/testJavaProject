package com.Object;

import com.stream.TestClass;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2020/10/10
 */
public class ObjectTest {

    public static void main(String[] args) {
        testInstanceof();
        //testUpdateObject();
    }

    /**
     * 测试Instanceof
     */
    private static void testInstanceof() {
        ClassGrandson classGrandson = new ClassGrandson();
        System.out.println(classGrandson instanceof ClassSon); //判断某个类是否属于另外一个类的子类或者原类 true
        System.out.println(ClassSon.class.isInstance(classGrandson)); //与instanceof完全等价，判断某个类是否属于另外一个类的子类或者原类  true
        System.out.println(ClassSon.class.isAssignableFrom(classGrandson.getClass())); //判断某个类是否属于另外一个类的子类或者原类  true

    }

    /**
     * 测试修改对象的属性值
     * 分别都赋予了值，成功
     */
    private static void testUpdateObject() {
        TestClass testClass = new TestClass();
        test1(testClass);
        test2(testClass);
        System.out.println(testClass.toString());
    }

    private static void test2(TestClass testClass) {
        testClass.setPro1("11");
    }

    private static void test1(TestClass testClass) {
        testClass.setPro2("222");
    }


}
