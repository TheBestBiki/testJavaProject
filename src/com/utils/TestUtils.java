package com.utils;

import com.stream.TestClass;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2020/9/15
 */
public class TestUtils {

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        testClass.setPro1("11");
        System.out.println(checkObjAllFieldsIsNull(testClass));
    }

    /**
     * 判断对象中属性值是否全为空
     *
     * @param object
     * @return
     */
    public static boolean checkObjAllFieldsIsNull(Object object) {
        if (null == object) {
            return true;
        }

        try {
            for (Field f : object.getClass().getDeclaredFields()) {
                //把私有属性公有化
                f.setAccessible(true);

                /*System.out.print(f.getName() + ":");
                System.out.println(f.get(object));*/

                if (f.get(object) != null && StringUtils.isNotBlank(f.get(object).toString())) {
                    return false;
                }
            }
        } catch (Exception e) {
            //logger.info("判断对象中属性值是否全为空报错：{}",e);
            return false;
        }

        return true;
    }

}
