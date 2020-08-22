package com.company;

public class Demo04SimpleLambda {
    //定义方法，使用接口当做参数
    public static void method(MyInterface m) {
        m.printStr("hello");
    }

    public static void main(String[] args) {

        //调用method方法，参数传递MyInterface实现类对象
        method(new MyInterface() {
            @Override
            public void printStr(String str) {
                System.out.println("匿名内部类"+str);
            }
        });
        //使用Lambda表达式的标准格式。
        method((String str) -> {
            System.out.println("Lambda"+str);
        });

        //1. 小括号中的参数类型可以省略。
        method((str) -> {
            System.out.println(str);
        });
        //2. 如果小括号中只有一个参数，那么可以省略小括号。
        method(str -> {
            System.out.println(str);
        });
        //3. 如果大括号中只有一条语句，那么可以省略大括号，return，分号。
        method(str -> System.out.println(str));
    }
}
