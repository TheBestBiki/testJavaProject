package com.String;

import java.io.Serializable;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2020/3/2
 */
public class StringA implements Serializable {

    private static final long serialVersionUID = 1L;

    private String aa;
    private String dd;
    private String cc;

    public StringA(String aa,String bb){
        this.aa=aa;
        this.dd=bb;
    }

    public StringA(String aa,String bb,String cc){
        this.aa=aa;
        this.dd=bb;
        this.cc=cc;
    }

    public StringA() {

    }

    public String getAa() {
        return aa;
    }

    public void setAa(String aa) {
        this.aa = aa;
    }

    public String getBb() {
        return dd;
    }

    public void setBb(String bb) {
        this.dd = bb;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    @Override
    public String toString() {
        return "StringA{" +
                "aa='" + aa + '\'' +
                ", dd='" + dd + '\'' +
                '}';
    }
}
