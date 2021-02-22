package com.algorithm;

import java.util.Arrays;

/**
 * @author biki
 * @date 2021/2/22
 * 冒泡排序算法
 *
 * 参考网址：https://www.cnblogs.com/xiaoming0601/p/5866048.html
 */
public class BubblingAlgorithmTest {

    public static void main(String[] args) {
        // 基本数据数组类型
        int arr[] = new int[]{1,6,2,2,5};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

        // 对象数组类型
        Integer arr2[] = new Integer[]{1,6,2,2,5};
        bubbleSortObject(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    /**
     * 原始版的冒泡排序算法
     *
     * 复杂度为O(n*n)
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        int temp;//定义一个临时变量
        for(int i=0;i<arr.length-1;i++){//冒泡趟数
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j+1]<arr[j]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    /**
     * 冒泡排序法存在的不足及改进方法：
     * 第一，在排序过程中，执行完最后的排序后，虽然数据已全部排序完备，但程序无法判断是否完成排序，
     *
     * 为了解决这一不足，可设置一个标志位flag，将其初始值设置为true，表示被排序的表是一个无序的表，
     * 每一次排序开始前设置flag值为false，在进行数据交换时，修改flag为true。
     * 在新一轮排序开始时，检查此标志，若此标志为false，表示上一次没有做过交换数据，则结束排序；否则进行排序；
     */

    /**
     * 冒泡排序算法改良版
     * 改良内容主要是加了
     * @param arr
     */
    public static void bubbleSortOptimization(int[] arr) {
        int temp;
        boolean flag = true; // 表示被排序的表是一个无序的表
        for (int i = 0; i < arr.length - 1 && flag; i++) {
            flag = false; // 排序开始前假设为是有序的表
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true; // 若有交换过位置，则认为该表还有可能是无序的表。若没交换，则flag的值还是为false，即没有交换过位置，是有序的表
                }
            }
        }
    }

    /**
     * 冒泡排序算法改良版
     * 这里的数组对象类型，要继承Comparable接口，并重写compareTo方法，因为这里是对象，比较大小需要调用Comparable的compareTo方法
     * @param arr
     * @param <T>
     */
    public static <T extends Comparable<T>> void bubbleSortObject(T[] arr) {
        T temp;
        boolean flag = true;
        for (int i = 0; i < arr.length - 1 && flag; i++) {
            flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
        }
    }


}
