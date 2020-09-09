package com.stream;

import com.String.StringA;
import com.String.StringB;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2020/3/26
 */
public class StreamTest {

    public static void main(String[] args) {
        /*StreamTest streamTest = new StreamTest();
        streamTest.testGroupingBy();*/

        //testFlatMap();

        //testOf();

        //testHeap();

        //testSorted();

        //testDistinctObject();

        Map<String,String> map = new HashMap<>();
        System.out.println(map.get(null));

    }

    /**
     * 测试用流去重对象
     */
    private static void testDistinctObject() {
        List<TestClass> lists = new ArrayList<>();
        lists.add(new TestClass("11"));
        lists.add(new TestClass("11"));
        Map<String, List<TestClass>> map = lists.stream().collect(Collectors.groupingBy(TestClass::toString));
        map.entrySet().forEach(entry->{
            entry.getValue().forEach(System.out ::println);
        });

        List<String> lists2 = new ArrayList<>();
        lists2.add("11");
        lists2.add("11");
        lists2.stream().distinct().forEach(System.out :: println);
    }

    /**
     * 测试排序
     * 前减后， 或者前.compare(后)  表示升序
     * 后减前， 或者后.compare(前)  表示降序
     *
     * sorted(Comparator.comparing(User::getAge))  根据age升序
     * sorted(Comparator.comparing(User::getAge).reversed())  根据age降序
     */
    private static void testSorted() {
        List<Integer> ints = new ArrayList<>(Arrays.asList(1,3,5,4,2));
        //下面2种写法是等效的
        ints.stream().sorted((e1,e2) -> e2.compareTo(e1)).forEach(System.out :: println);
        ints.stream().sorted((e1,e2) -> e2 - e1).forEach(System.out :: println);

        //当List是Integer类型时的双冒号写法
        ints.stream().sorted(Comparator.comparing(Integer::intValue)).forEach(System.out :: println);

    }

    /**
     * 测试什么时候执行
     */
    private static void testHeap() {
        List<String> strs = new ArrayList<>(Arrays.asList("11","11","22"));
        strs.stream().distinct();
        for (String str : strs) {
            System.out.println(str+"---");//11  11  22
        }
    }

    /**
     * 类似于List的add方法
     */
    private static void testOf() {
        Stream<String> test = Stream.of("11", "22");
        // 或者
        List<String> strList = Stream.of("11", "22").collect(Collectors.toList());
        //类似于
        strList.add("11");
        strList.add("22");
    }

    /**
     * 测试flatMap
     *
     * 条件：集合里的对象里，也有List属性
     * flatMap的作用就是，将不同对象里相同的List属性，合成一个大的List
     *
     * 一般用来取集合里面不同对象的所有相同list
     */
    private static void testFlatMap() {
        List<TestClass> tests = new ArrayList<>();

        TestClass test1 = new TestClass();
        List<String> eggs1 = new ArrayList<>(Arrays.asList("鸡蛋1","鸡蛋11"));
        test1.setStrList(eggs1);
        TestClass test2 = new TestClass();
        List<String> eggs2 = new ArrayList<>(Arrays.asList("鸡蛋2","鸡蛋22"));
        test2.setStrList(eggs2);

        tests.add(test1);tests.add(test2);

        List<String> allStrListInOneList = tests.stream().flatMap(x -> x.getStrList().stream()).collect(Collectors.toList());
        allStrListInOneList.stream().forEach(System.out :: println);
    }

    /**
     * 测试流的分组
     */
    private void testGroupingBy() {
        List<StringA> baseList = new ArrayList<>();
        baseList.add(new StringA("bi","k","i"));
        baseList.add(new StringA("bi","k222","i"));
        baseList.add(new StringA("bi","k","i"));
        Map<String, List<StringA>> map = baseList.stream().collect(Collectors.groupingBy(this::genKey));
        for(String a : map.keySet()){
            System.out.println(a+"---------"+map.get(a));
        }
    }

    /**
     * 构造Key
     * @param item
     * @return
     */
    private String genKey(StringA item) {
        StringBuilder builder = new StringBuilder();
        builder.append(item.getAa()).append("/").append(item.getBb());
        return builder.toString();
    }



    /*public static void main(String[] args) {
        *//* List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        // 获取空字符串的数量
        long count = strings.stream().filter(string -> !string.isEmpty()).count();
        List<String> strings2 = strings.stream().sorted().collect(Collectors.toList());
        System.out.println(strings2);*//*

        *//*List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        System.out.println("筛选列表: " + filtered);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);*//*

        *//*List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        // 获取空字符串的数量
        long count = strings.stream().filter(string -> string.isEmpty()).count();
        System.out.println(strings.toString());*//*

        *//*List<Integer> str = new ArrayList<>();
        str.add(1);
        str.add(2);
        str.add(3);
        List<Integer> str2=str.stream().skip(1).collect(Collectors.toList());
        System.out.println(str2.toString());*//*

        *//*List<Integer> str = new ArrayList<>();
        str.add(1);
        str.add(2);
        str.add(3);
        Map<Integer,Integer> map1 = str.stream().collect(Collectors.toMap(x->x+2,x->x+3));
        for(Map.Entry<Integer,Integer> map : map1.entrySet()){
            System.out.println(map.getKey()+"---"+map.getValue());
        }*//*


        *//*List<StringB> str = new ArrayList<>();
        StringB b1 = new StringB("1");
        StringB b2 = new StringB("2");
        StringB b3 = new StringB("3");
        str.add(b1);str.add(b2);str.add(b3);
        Map<String,StringB> map1 = str.stream().collect(Collectors.toMap(StringB::getAa,StringB->StringB));
        for(Map.Entry<String,StringB> map : map1.entrySet()){
            System.out.println(map.getKey()+"---"+map.getValue());
        }*//*

        *//*Set<String> set = new HashSet<>();
        set.add("1");
        set.add("2");
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        for(String a: set){
           System.out.println(a);
        }*//*

        *//*
        List<String> strs = Arrays.asList("a", "b", "c");
        String[] dd = strs.stream().toArray(str -> new String[strs.size()]);
        for(String a : dd){
            System.out.println(a);
        }
        //输出a b c
        *//*
    }*/





}
