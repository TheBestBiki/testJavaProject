package com.BigDecimal;

import java.math.BigDecimal;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2020/9/26
 */
public class BigDecimalTest {

    /**
     * BigDecimal不管是什么运算，计算后的值都要重新接收
     * @param args
     */

    public static void main(String[] args) {
        //testPoint();

        //testCalculation();

        BigDecimal z = BigDecimal.ZERO;
        z = z.add(new BigDecimal(3));

        System.out.println(z);
    }

    private static void testCalculation() {
        BigDecimal aa = new BigDecimal(1);
        aa =aa.add(new BigDecimal(2));// 这里得重新接收才行
        System.out.println(aa.toString());
    }

    /**
     * BigDecimal的setScale方法，第一个参数为最终截取为几位小数，第二个参数为要四舍五入还是直接舍弃等
     *
     * BigDecimal.ROUND_DOWN       直接去掉多余的位数-->  2.36777->2.36
     * BigDecimal.ROUND_UP         跟上面相反，进位处理-->2.36777->2.37
     * BigDecimal.ROUND_HALF_UP    四舍五入（若舍弃部分>=5，就进位）-->  2.36777->2.37
     * BigDecimal.ROUND_HALF_DOWN  四舍五入（若舍弃部分>5，才进位）-->  2.36555->2.36
     */
    private static void testPoint() {
        BigDecimal num = new BigDecimal("11.55");
        if(num.setScale(2, BigDecimal.ROUND_DOWN).compareTo(num) !=0){
            System.out.println(num+"不一样");
        }else {
            System.out.println(num+"一样");
        }


    }

}
