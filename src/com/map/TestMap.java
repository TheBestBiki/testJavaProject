package com.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2020/7/14
 */
public class TestMap {

    public static void main(String[] args) {
        /*Integer a=10;
        int b=10;
        System.out.println(a.equals(b));*/

        Map<String,String> map = new HashMap<>();
        map.put("1","1");
        map.put("1","2");
        System.out.println(map.get("1"));

        String str="11,22,33";
        str.split(str);


        //testAddListNodeInMap();

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
