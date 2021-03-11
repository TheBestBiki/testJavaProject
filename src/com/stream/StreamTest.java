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

        //testGroupingBy();

        //testFlatMap();

        //testOf();

        //testHeap();

        testSorted();

        //testDistinctObject();

        //testStreamCount();
        //testReturnForeach();

        //testDistinctManySameProperty();

        //testSetSoet();
    }

    /**
     * 排序 默认是a-b升序， b-a则是降序
     */
    private static void testSetSoet() {
        Set<Integer> orderProIdSet = new TreeSet<>((a, b) -> b - a);
        orderProIdSet.add(4);
        orderProIdSet.add(3);
        orderProIdSet.add(1);
        orderProIdSet.add(2);
        orderProIdSet.stream().forEach(System.out::println);
    }

    /**
     * set注意的点：
     * TreeSet<User> treeSet = new TreeSet<>(Comparator.comparing(User::getName)); //根据条件去重
     * Set<Integer> orderProIdSet = new TreeSet<>((a, b) -> b - a); // 排序 默认是a-b升序， b-a则是降序
     *
     * 根据对象的单个或者多个属性进行去重
     * Collectors.collectingAndThen 也不会改变原集合的所有值
     * Stream不会改变源对象。相反，它们会返回一个持有结果的新Stream
     *
     * https://blog.csdn.net/qq_35634181/article/details/108867857
     */
    private static void testDistinctManySameProperty() {
        List<TestClass> list = new ArrayList<>();
        list.add(new TestClass("11","22"));
        list.add(new TestClass("11","22"));
        list.add(new TestClass("11","33"));
        // 单个  根据pro1属性进行去重
        ArrayList<TestClass> distinctList1 = list.stream().collect(Collectors.collectingAndThen(
                Collectors.toCollection(() -> new TreeSet<>(
                        Comparator.comparing(
                                TestClass::getPro1))), ArrayList::new));
        // 多个  根据pro1,pro2属性进行去重
        ArrayList<TestClass> distinctList2 = list.stream().collect(Collectors.collectingAndThen(
                Collectors.toCollection(() -> new TreeSet<>(
                        Comparator.comparing(p->p.getPro1() + ";" + p.getPro2()))), ArrayList::new));
        System.out.println(distinctList1);
        System.out.println(distinctList2);
    }

    /**
     * 测试在流里面的foreach里用return，能达到普通for循环continue的效果
     */
    private static void testReturnForeach() {
        List<TestClass> list = new ArrayList<>();
        list.add(new TestClass("11"));
        list.add(new TestClass("2"));
        list.add(new TestClass("22"));
        list.add(new TestClass("2"));
        list.add(new TestClass("3"));
        list.stream().forEach(s->{
            if(s.getPro1().equals("2")){
                return;
            }
            System.out.println(s.getPro1());
        });
    }

    private static void testStreamCount() {
        List<TestClass> list = new ArrayList<>();
        list.add(new TestClass("11"));
        list.add(new TestClass("22"));
        list.add(new TestClass("22"));
        System.out.println(list.stream().map(TestClass :: getPro1).distinct().count());
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
     * 前减后， 或者前.compare(后)  表示默认的升序
     * 后减前， 或者后.compare(前)  表示默认的降序
     *
     * list.stream.sorted(); // 在集合里面调用sorted方法，则集合的泛型List<XXX>中，类XXX必须实现了Comparable接口，并重写compareTo方法；
     * 否则调用sorted方法失败，因为sort方法最后还是要调用类XXX的compareTo方法来比较2个类的排列顺序
     * 不实现Comparable接口也可以，用下面这种根据类XXX的某个自动来排序
     *
     * sorted(Comparator.comparing(User::getAge))  根据age升序
     * sorted(Comparator.comparing(User::getAge).reversed())  根据age降序
     * 在集合里面，用这种方式调用sorted方法，就不会报错，这种是根据类的某个字段来排序
     *
     * Comparator参考网址（写在类外）：https://blog.csdn.net/kuishao1314aa/article/details/100527985
     * Comparable与Comparator的区别（写在类里）：https://blog.51cto.com/6949410/1869032
     *
     */
    private static void testSorted() {
        List<Integer> ints = new ArrayList<>(Arrays.asList(1,3,5,4,2));
        //下面2种写法是等效的
        ints.stream().sorted((e1,e2) -> e2.compareTo(e1)).forEach(System.out :: print);
        System.out.println("");
        System.out.println("----------");
        ints.stream().sorted((e1,e2) -> e2 - e1).forEach(System.out :: print);

        System.out.println("");
        System.out.println("----------");

        System.out.println("---");
        //当List是Integer类型时的双冒号写法
        ints.stream().sorted(Comparator.comparing(Integer::intValue)).forEach(System.out :: println);

        System.out.println("");
        System.out.println("----------");

        List<TestClass> lists = new ArrayList<>();
        lists.add(new TestClass("11"));
        lists.add(new TestClass("22"));
        lists.add(new TestClass("12"));
        // 根据Pro1属性降序，不加reversed就是升序
        lists.stream().sorted(Comparator.comparing(TestClass::getPro1).reversed()).forEach(System.out :: println);
        // 这里sorted() 是调用TestClass的compareTo方法来比较集合里前后2个元素的大小的，默认升序
        lists.stream().sorted().forEach(System.out :: println);
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
     * 01--可以用流里的对象的字段来组装key
     * 02--测试List<String>
     */
    private static void testGroupingBy() {
        // 01
        /*List<StringA> baseList = new ArrayList<>();
        baseList.add(new StringA("bi","k","i"));
        baseList.add(new StringA("bi","k222","i"));
        baseList.add(new StringA("bi","k","i"));
        Map<String, List<StringA>> map = baseList.stream().collect(Collectors.groupingBy(this::genKey));
        for(String a : map.keySet()){
            System.out.println(a+"---------"+map.get(a));
        }*/

        List<String> strs = new ArrayList<>(Arrays.asList("11","22","33","22"));
        Map<String, List<String>> map = strs.stream().collect(Collectors.groupingBy(String::toString));
        System.out.println(map.toString());

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
