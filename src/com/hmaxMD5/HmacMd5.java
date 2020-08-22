package com.hmaxMD5;


import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2020/3/4
 */
public class HmacMd5 {

    public static final char[] DIGITS_UPPER = { '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

    /**
     * 原理：将data中的每个byte元素拆分为两个十六进制数，作为DIGITS_UPPER数组的下标，然后找到其对应的char字符，组装成一个char[]数组
     * @param data
     * @return
     */
    public static String byte2HexString(final byte[] data) {
        final int l = data.length;
        final char[] out = new char[l << 1];
        // two characters form the hex value.
        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = DIGITS_UPPER[(0xF0 & data[i]) >>> 4];
            out[j++] = DIGITS_UPPER[0x0F & data[i]];
        }
        return new String(out);
    }

    /**
     * HmacMD5加密
     * @param secretKey   加密密钥
     * @param lockBody    被加密的内容
     * @return
     * @throws Exception
     */
    public static String encryptionHmacMD5(String secretKey,String lockBody) throws Exception {
        //构建一个密钥
        SecretKey sk = new SecretKeySpec(secretKey.getBytes("UTF-8"),"HmacMD5");
        //选择算法
        Mac mac = Mac.getInstance("HmacMD5");
        //mac初始化
        mac.init(sk);
        //对被加密的内容lockBody进行加密
        byte[] result = mac.doFinal(lockBody.getBytes("UTF-8"));
        //转成字符串类型
        String resultStr  = byte2HexString(result);
        return resultStr;
    }



    /**
     * @param argv
     * @throws Exception
     */
    public static void main(String[] argv) throws Exception {
        String key = "ulhHhzSnXyuZGjlN";
        String body="{\"app_label\": \"dim_product\", \"model\": \"blacklistdspn\"}";
        System.out.print(encryptionHmacMD5(key,body));
    }

}
