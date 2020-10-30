package com.elseTest;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2020/10/28
 */
public class Test {

    public static void main(String[] args) {
        //retryTest();
        Test test = new Test();
        test.retryTest();

    }

    /**
     * 测试--用for来实现重试机制
     */
    private  void retryTest() {
        try{
            uploadFile(1);
        }
        catch(Exception e){
            for(int i=0;i<4;i++){
                try{
                    uploadFile(i);
                    System.out.println("成功");
                    break;
                }catch (Exception ex){
                    System.out.println("重试异常"+i);
                }
            }
        }
    }

    private void uploadFile(int count) {
        if(count < 2){
            throw new  IllegalArgumentException("第一次上传异常");
        }
    }

}
