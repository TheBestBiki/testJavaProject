package com.byteTest;

/**
 * @author biki
 * @date 2021/3/8
 */
public class ByteTest {

    /*
     0x开头,代表的是16进制数，0x只是前缀，不参与计算
     0开头的,代表的是8进制数，0只是前缀，不参与计算
     如：16进制转10进制  0x61 = 61 = 6*(16^1) + 6*(16^0) = 6*16 + 6*1 = 97(十进制)  97对照ASCII编码表即可知道是字符 a
        8进制转10进制   同理056=46(十进制)


     每个编码表都有编码与字符的对应关系，如字母a：在iso8859-1编码表中，a的编码是0x61，即为16进制，转换为十进制就是我们常说的 字母a的编码为97


     */

    public static void main(String[] args) {
        String chinese = "中";
        for (byte aByte : chinese.getBytes()) {
            System.out.println(aByte);
        }

    }



}
