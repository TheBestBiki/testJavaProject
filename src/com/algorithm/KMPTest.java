package com.algorithm;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2021/3/11
 *
 * KMP算法 参考网址：https://blog.csdn.net/v_july_v/article/details/7041827
 */
public class KMPTest {

    public static void main(String[] args) {
        //testCharAt();

    }

    private static void testCharAt() {
        String test = "中国";
        for(int i=0;i<test.length();i++){
            char b = test.charAt(i);
            System.out.println(b);
            System.out.println((byte)b);
        }
    }

}
