package com.list;

import com.String.StringA;
import com.stream.TestClass;
import org.apache.commons.collections.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2020/7/15
 */
public class TestList {

    public static List<String> NOT_SEND_STATUS = Arrays.asList("停产","临时停售","不销售","未发布");


    public static void main(String[] args) {
        //main2(); // 测试增强for循环的指针
        //main3(); // 测试List，用foreach后还会不会按添加顺序读取展示
        //testStreamForeachList();

        //testSubList();

        //testSubListUtil();

        //testStringBuilderAppendNull();

        //testForeach();

        //testAddSameObjects();

        //testContainsNull();

        //testSetListValueInMethod();

        /*String ss = "20201010-3";
        System.out.println(ss.substring(9));

        List<Integer> ii = new ArrayList<>(Arrays.asList(2,3,5));
        // System.out.println(ii.stream().sorted((x,y)->(y.compareTo(x))).collect(Collectors.toList()).toString());
        List<Integer> collect = ii.stream().sorted((x, y) -> (y.compareTo(x))).collect(Collectors.toList());
        String s = "20200113"+"-"+(collect.get(0)+1);
        System.out.println(s);*/

        List<String> aa = new ArrayList<>();
        System.out.println(aa.size());
        System.out.println(aa.stream().map(a->a+"11").collect(Collectors.toList()));

    }

    /**
     * 方法外的List对象在其它方法里面赋值测试
     *
     * 方法外的List必须实例化
     * 在其它方法里面用add才能给该List赋值
     */
    private static void testSetListValueInMethod() {
        List<String> strs = new ArrayList<>();
        testObject(strs);
        System.out.println(strs);
    }

    private static void testObject(List<String> strs2) {
        List<String> strs = new ArrayList<>();
        strs.add("11");
        strs.add("12");
        strs2=strs; //这里用等于没用
        strs2.addAll(strs2); //add才会改变外部strs2的值
    }

    /**
     * 测试apache的subtract
     * 结果：subtract里的第一、二个参数为空都不会报错
     */
    private static void testSubListUtil() {
        List<String> baseList = new ArrayList<>(Arrays.asList("11","22"));
        List<String> result = (List<String>)CollectionUtils.subtract(baseList,new ArrayList());
        System.out.println(result.toString());

    }

    /**
     * 测试contains的值为空时报错不
     *
     * 不报错，返回false
     */
    private static void testContainsNull() {
        //List<String> aa = Arrays.asList("11","22");
        System.out.println(NOT_SEND_STATUS.contains(null));
    }

    /**
     * 测试添加一个对象，将该对象修改后，再重新添加一遍
     * 结果打印出来的2个对象指向的是同一个地址，打印的内容也一样
     */
    private static void testAddSameObjects() {
        List<TestClass> lists = new ArrayList<>();
        TestClass testClass = new TestClass("111");
        lists.add(testClass);
        testClass.setPro2("22");
        lists.add(testClass);
        lists.stream().forEach(System.out ::println);
    }

    /**
     * foreach可以改变list里面原有属性的属性
     */
    private static void testForeach() {
        List<TestClass> aa = new ArrayList<>();
        aa.forEach(e->{
            e.setPro1("1111");
        });
        System.out.println("333");
    }

    /**
     * 测试append的值为null时会不会报错
     * 结论：不会
     */
    private static void testStringBuilderAppendNull() {
        StringBuilder builder = new StringBuilder();
        String aa = null;
        builder.append("11").append("/").append(aa).append("/").append("22");
        System.out.println(builder.toString()); // 结果：11/null/22
    }


    /**
     * 测试subList
     */
    private static void testSubList() {
        List<Integer> aa = new ArrayList<>(Arrays.asList(0,1,2,3,4));
        aa = aa.subList(2,4);
        aa.stream().forEach(System.out :: println);
    }

    /**
     * 测试用stream流中的foreach来修改list中的对象
     * 用foreach只能修改list中的对象的属性，而不能让list中的对象 等于另外一个对象
     * 如果一定要让list中的对象等于另外一个新对象，则要用普通for循环，用list的set方法来做
     */
    private static void testStreamForeachList() {
        List<StringA> la = new ArrayList<>();
        la.add(new StringA("11","22"));
        la.add(new StringA("111","222"));
        /*la.stream().forEach(e->{
            e.setAa("aa");
            e.setBb("bb");
            e=new StringA(); // 不起作用
        });*/
        for(int i=0;i<la.size();i++){
            la.set(i,new StringA());
        }
        // foreach循环：[StringA{aa='aa', dd='bb'}, StringA{aa='aa', dd='bb'}]
        // 普通for循环：[StringA{aa='null', dd='null'}, StringA{aa='null', dd='null'}]
        System.out.println(la.toString());
    }

    /**
     * 测试List，用foreach后还会不会按添加顺序读取展示
     * 结果：会
     */
    public static void main3() {
        List<String> aaList = new ArrayList<>();
        aaList.add("44");
        aaList.add("22");
        aaList.add("33");
        Integer sort=0;
        for(String a : aaList){
            System.out.println(a+"-------"+sort);
            sort++;
        }
    }

    /**
     * 测试List，用foreach修改后的指针问题
     * 结果： 指针指向同一处
     */
    public static void main2() {
        List<StringA> aaList = new ArrayList<>();
        StringA string1 = new StringA();
        string1.setAa("11");
        StringA string2 = new StringA();
        string2.setAa("111");
        aaList.add(string1);
        aaList.add(string2);
        addBb(aaList);
        for(StringA a : aaList){
            System.out.println(a.toString());
        }
    }


    private static void addBb(List<StringA> aaList) {
        for(StringA a : aaList){
            a.setBb("bbbbb");
            changeProperty(a);
        }
        return;
    }

    private static void changeProperty(StringA a) {
        a.setAa("changeValue");
        return;
    }



}
