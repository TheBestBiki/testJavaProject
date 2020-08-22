package com.String;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2020/7/1
 */
public class StringC extends StringA {

    private String cc;

    public StringC(String aa, String bb) {
        super(aa, bb);
    }

    public StringC() {
        super();
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }
}
