package com.byteTest;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 创建byte的三种方式：https://blog.csdn.net/jdbfvhxx/article/details/95377739
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
     即

     */

    public static void main(String[] args) throws UnsupportedEncodingException {
        testByteSave();

    }

    /**
     * 测试字符串转byte数组时数据存储的情况
     * 结论：1.
     * @throws UnsupportedEncodingException
     */
    private static void testByteSave() throws UnsupportedEncodingException {
        // 获得字符串的对应UTF-8编码表的16进制数
        String str = URLEncoder.encode("中", "UTF-8").replace("%", "");
        System.out.println(str); // 得字符串"中"对应的16进制为E4B8AD
        System.out.println("================");
        String chinese = "中";
        // 因为UTF-8里一个字符串占3个字节，所以转为byte数组时，实际上数组的长度为3，即 E4 B8 AD
        // 但是byte数组不可能存成{E4,B8,AD},因为byte的存储范围只有-128~127
        // 所以实际上，字符串转byte数组时，byte数组里存的是补码，
        // 即：E4原码：228(10进制)=1110 0100，反码为：1001 1011 ，补码：1001 1100 = -28
        // 同理得B8的补码为：-72，AD的补码为-83
        // 所以byte数组里，存的是{-28,-72,-83}
        byte[] bytes = chinese.getBytes();
        // 循环3次打印的结果：-28 -72 -83
        for (byte aByte : bytes) {
            System.out.println(aByte);
        }
        // byte数组转字符串时，因为字符串占3个字节，因此会将每3个byte，即3个字节合为一个字符串
        // 该过程中，byte数组的每个byte会先取补码，再将补码合起来
        // 即：-28=1001 1100，得补码为：1110 0100 = 228 = E4，发现与"中"的16进制里前面2位一样
        // 同理得-72的补码为B8，-83的补码为AD，3个合起来就是E4B8AD，再通过该编码，到UTF-8编码表里，找到了字符"中"
        String aa = new String(bytes);
        System.out.println("String的方法获得数组，再将数组转String后的结果->"+aa);

        System.out.println("================负数转byte");
        byte[] testBytes ={-28,-72,-83};
        System.out.println(new String(testBytes)); // 中

        System.out.println("================快速求byte的补码");
        System.out.println(testBytes[0] & 0xff); // 228,这种方式可以直接得-28的补码，原理见https://www.cnblogs.com/zhangcaiwang/p/14251795.html
        System.out.println("================测试正数的byte");
        byte[] byte2 ={97};
        System.out.println(byte2[0] & 0xff); //结果还是本身，正数的补码也还是其本身

        System.out.println("================16进制转byte");
        byte[] byte16 ={(byte)0xE4,(byte)0xB8,(byte)0xAD};
        for (byte b : byte16) {
            System.out.println(b);
        }


    }

    /**
     * 字符串转16进制
     * 不加replaceAll的话，结果是类似这样的形式：%E4%B8%AD
     * @param str 字符串
     * @param encode 编码格式
     * @return
     */
    public static String strTo16(String str,String encode) {
        try {
            return URLEncoder.encode("中", "utf-8").replace("%", "");
        }catch (Exception e){
            System.out.println(e);
            return "字符串转16进制失败";
        }
    }

    /**
     * 字符串转化成为16进制字符串
     * @param s
     * @return
     */
    public static String strTo16(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            int ch = (int) s.charAt(i);
            String s4 = Integer.toHexString(ch);
            str = str + s4;
        }
        return str;
    }


}
