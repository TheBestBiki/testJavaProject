package com.Object;

import com.stream.StreamTest;
import com.stream.TestClass;
import com.stream.TestClassSon;

import java.util.ArrayList;
import java.util.List;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2020/10/10
 */
public class ObjectTest {

    public static void main(String[] args) {
        testInstanceof();
        //testUpdateObject();

        /*List<TestClass> list = new ArrayList<>();
        testSuper(list);*/


    }

    /**
     * 这里要求入参是TestClassSon，或者是TestClassSon的父类
     * 尖括号里面的语句，类似于一个判断语句，必须满足是某类的父类或者本身才行
     * @param a
     */
    private static void testSuper(List<? super TestClassSon> a){

    }

    /**
     * 这里要求入参是TestClass，或者是TestClass的子类
     * 尖括号里面的语句，类似于一个判断语句，必须满足是某类的子类或者本身才行，Object作为入参的泛型也不行
     *
     * 若泛型里面指定了某种类型，没有继承关系，那么，入参的泛型，就得一模一样
     * 如方法  testAa(List<TestClass> a), 则调用该方法的入参的泛型，一定得是List<TestClass>， 就算是TestClass的子类或者父类都不行，会报编译错误
     * @param a
     */
    private static void testExtends(List<? extends TestClass> a){

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
