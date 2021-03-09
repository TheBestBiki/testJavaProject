package com.json;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2020/11/26
 */
public class TestJson {

    public static void main(String[] args) {
        //testMapAndObjectToJson();


    }

    /**
     * 测试map跟对象字段一样的情况下，转换为json时是否一样
     * 结论：一样
     */
    private static void testMapAndObjectToJson() {
        Map<String,Integer> map = new HashMap<>();
        map.put("id",1);
        System.out.println(JSON.toJSONString(map));
        User user = new User();
        user.setId(1);
        System.out.println(JSON.toJSONString(user));
    }


    public static class User{
        private Integer id;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }

}
