package com.list;

import com.String.StringA;

import java.util.ArrayList;
import java.util.List;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2020/7/15
 */
public class TestList {

    public static void main(String[] args) {
        //main2(); // 测试增强for循环的指针
        //main3(); // 测试List，用foreach后还会不会按添加顺序读取展示
        testStreamForeachList();
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
