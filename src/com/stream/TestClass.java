package com.stream;

import java.util.List;
import java.util.Objects;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2020/8/22
 */
public class TestClass {

    private String pro1;

    private String pro2;

    private String pro3;

    private List<String> strList;

    private List<TestClassSon> sonList;

    public TestClass() {
    }

    public TestClass(String pro1) {
        this.pro1 = pro1;
    }

    public TestClass(String pro1, String pro2) {
        this.pro1 = pro1;
        this.pro2 = pro2;
    }

    public TestClass(String pro1, String pro2, String pro3) {
        this.pro1 = pro1;
        this.pro2 = pro2;
        this.pro3 = pro3;
    }

    public TestClass(String pro1, String pro2, String pro3, List<String> strList) {
        this.pro1 = pro1;
        this.pro2 = pro2;
        this.pro3 = pro3;
        this.strList = strList;
    }

    public String getPro1() {
        return pro1;
    }

    public void setPro1(String pro1) {
        this.pro1 = pro1;
    }

    public String getPro2() {
        return pro2;
    }

    public void setPro2(String pro2) {
        this.pro2 = pro2;
    }

    public String getPro3() {
        return pro3;
    }

    public void setPro3(String pro3) {
        this.pro3 = pro3;
    }

    public List<String> getStrList() {
        return strList;
    }

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }

    public List<TestClassSon> getSonList() {
        return sonList;
    }

    public void setSonList(List<TestClassSon> sonList) {
        this.sonList = sonList;
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "pro1='" + pro1 + '\'' +
                ", pro2='" + pro2 + '\'' +
                ", pro3='" + pro3 + '\'' +
                ", strList=" + strList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestClass)) return false;
        TestClass testClass = (TestClass) o;
        return Objects.equals(pro1, testClass.pro1) &&
                Objects.equals(pro2, testClass.pro2) &&
                Objects.equals(pro3, testClass.pro3) &&
                Objects.equals(strList, testClass.strList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pro1, pro2, pro3, strList);
    }
}
