package com.testClass;

import com.String.StringA;
import com.String.StringC;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2020/7/1
 */
public class TestExtends {

    public static void main(String[] args) {
        //关键是new后面的类是StringC，而不是StringA
        StringA a1 = new StringC("11","22");
        ((StringC)a1).setCc("33");
        vv(a1);
    }

    private static void vv(StringA va){
        System.out.println(((StringC)va).getCc());
        return;
    }
}
