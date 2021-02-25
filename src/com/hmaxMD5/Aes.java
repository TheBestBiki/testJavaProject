package com.hmaxMD5;

import javax.crypto.KeyGenerator;
import java.security.SecureRandom;

/**
 * @author biki
 * @date 2021/2/25
 *
 * 参考网址：https://blog.csdn.net/baidu_22254181/article/details/82594072
 */
public class Aes {

    public static void main(String[] args) {
        byte[] aa =randomKey(128);
        for (byte b : aa) {
            System.out.println(b);
        }
        System.out.println(aa.length+"--"+aa.toString());
    }


    public static byte[] randomKey(int size) {
        byte[] result = null;
        try {
            KeyGenerator gen = KeyGenerator.getInstance("AES");
            gen.init(size, new SecureRandom());
            result = gen.generateKey().getEncoded();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }


}
