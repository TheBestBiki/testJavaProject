package com.algorithm;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2020/6/11
 * 递归算法测试
 */
public class RecursiveTest {

    public static void main(String[] args) {
        System.out.println(demo(3));
    }

    public static int demo(int n) {
        if (n == 1) {
            return 1;
        } else {
            return demo(n - 1);
        }
    }
}
