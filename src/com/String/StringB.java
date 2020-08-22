package com.String;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2020/3/2
 */
public class StringB {

    private String aa;
    private String bb;
    private String cc;

    public StringB(String aa){
        this.aa=aa;
    }

    public StringB(String aa,String bb,String cc){
        this.aa=aa;
        this.bb=bb;
        this.cc=cc;
    }

    public StringB() {

    }

    public String getAa() {
        return aa;
    }

    public void setAa(String aa) {
        this.aa = aa;
    }

    public String getBb() {
        return bb;
    }

    public void setBb(String bb) {
        this.bb = bb;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }
}
