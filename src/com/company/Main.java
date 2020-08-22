package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        //Bbbbb<Ddd> bb=new Bbbbb();
        //int x=10;
        //System.out.println(x+=x-=x-x++);

        //stream用法  一般是用来在原来集合的基础上，构建一个新的集合
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        //foreach跟之前用的foreach(int i:numbers)用法一样，只是简化了写法
        //这里的stream可加可不加，结果一样
        numbers.stream().forEach(i ->{
            i=i*2;
            System.out.println(i);
        });

        // 获取对应的平方数    这里map有点类似于foreach的效果     distinct()是去重的意思，在这里也可以去掉  不去掉是9 4 49 25   去掉是9 4 4 9 49 9 25
        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        System.out.println(squaresList.get(0));//9
        squaresList.forEach(System.out::println);//输出squaresList中的所有值： 9 4 49 25  中间加2个冒号，才能自动填，否则就要像上面的foreach那样的写法

        List<String> strings = Arrays.asList("abc", "", "bc", "efg");
        // 获取空字符串的数量
        //long count = strings.stream().filter(string -> string.isEmpty()).count();
        List<String> newStrings=strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        newStrings.forEach(System.out::println);
        //System.out.println(newStrings.size());
    }
}
