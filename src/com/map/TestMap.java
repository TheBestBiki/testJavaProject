package com.map;

import com.stream.TestClass;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Map删除的参考网址：https://blog.csdn.net/harryptter/article/details/77477684
 * 各种Map的对比的参考网址：https://www.cnblogs.com/coder-lzh/p/10819627.html
 *
 * @author o-Biki.huang
 * @version 1.0
 * @date 2020/7/14
 */
public class TestMap {

    public static void main(String[] args) {

        testMapRemove();

        // ---------------------------------------------------------

        /*Integer a=10;
        int b=10;
        System.out.println(a.equals(b));*/

        /*Map<String,String> map = new HashMap<>();
        map.put("1","1");
        map.put("1","2");
        System.out.println(map.get("1"));

        String str="11,22,33";
        str.split(str);*/


        //testAddListNodeInMap();

        //testMapToNewAddress();

        /*int i=0;
        i= 1==0 ? i : ++i;
        i= 1==0 ? i : ++i;
        i= 1==0 ? i : ++i;
        System.out.println(i);*/

        /*List<TestClass> list = new ArrayList<>();
        list.add(new TestClass("11"));
        Map<String, String> collect = list.stream().collect(Collectors.toMap(TestClass::getPro1, t->t.getPro2()));
        Map<String,String> map= new HashMap<>();
        map.put("11",null);*/

        /*// get的key也区分大小写
        Map<String,String> map = new HashMap<>();
        map.put("dji-cloudbus-prm-authorization","1111");
        System.out.println(map.get("Dji-Cloudbus-Prm-Authorization"));*/

    }

    /**
     * 在循环里删除Map的元素的方法
     * 普通的for循环map，然后调用map.remove()方法，容易引发java.util.ConcurrentModificationException异常
     * 这是由于我们在遍历HashMap的元素过程中删除了当前所在元素，下一个待访问的元素的指针也由此丢失了
     *
     * 用迭代器Iterator 来删除是最保险的
     */
    private static void testMapRemove() {
        Map<String, List<String>> map= new HashMap<>();
        for(Iterator<Map.Entry<String, List<String>>> it = map.entrySet().iterator(); it.hasNext();){
            Map.Entry<String, List<String>> item = it.next(); // 获取下一个元素
            // 逻辑判断
            it.remove();
        }
    }

    /**
     * map跨方法的话，需要用put或者putAll才可以给原始的map赋值
     */
    private static void testMapToNewAddress() {
        Map<String,String> sMap = new HashMap<>();
        newvalue(sMap);
        System.out.println(sMap);
    }

    private static void newvalue(Map<String, String> sMap) {
        Map<String,String> map = new HashMap<>();
        map.put("11","11");
        sMap.putAll(map);
    }

    /**
     * 测试给map中的list添加元素
     */
    private static void testAddListNodeInMap() {
        Map<String, List<String>> map1= new HashMap<>();
        List<String> sl = new ArrayList<>();
        sl.add("11");
        sl.add("22");
        sl.add("33");
        map1.put("aa",sl);
        System.out.println(map1.toString());
        /*map.get("aa").add("33");
        System.out.println(map.toString());*/

        Map<String, List<String>> map= new HashMap<>();
        for(String priceAreaAndTypeDto : sl){
            if(map.get("aa") == null){
                List<String> priceTypeConfigList = new ArrayList<>();
                String priceTypeConfig = priceAreaAndTypeDto;
                priceTypeConfigList.add(priceTypeConfig);

                map.put("aa",priceTypeConfigList);
            }
            else{
                String priceTypeConfig = priceAreaAndTypeDto;
                map.get("aa").add(priceTypeConfig);
            }
        }
        System.out.println(map.toString());

    }




}
