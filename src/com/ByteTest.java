package com;

import com.date.DateTest;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2020/9/24
 */
public class ByteTest {

    public static void main(String[] args) {
        testSetByte();
    }

    private static void testSetByte() {
        ByteTestClass byteTest = new ByteTestClass();
        byteTest.setB(RecognitionTypeEnum.WO_PARAGRAPH.getCode());
        System.out.println(byteTest.getB());
        System.out.println(RecognitionTypeEnum.WO_PARAGRAPH.getCode().equals(byteTest.getB()));
        System.out.println(RecognitionTypeEnum.WO_PARAGRAPH.getCode().equals(byteTest.getB()));
    }

    private static class ByteTestClass{
        private Byte b;

        public Byte getB() {
            return b;
        }

        public void setB(Byte b) {
            this.b = b;
        }
    }

    public enum RecognitionTypeEnum {
        WO_PARAGRAPH("到款",(byte)1),
        WO_CREDITMEMO("CM",(byte)2);


        RecognitionTypeEnum(String desc, Byte code) {
            this.desc = desc;
            this.code = code;
        }

        private String desc;

        private Byte code;

        public String getDesc() {
            return desc;
        }

        public Byte getCode() {
            return code;
        }
    }

}
