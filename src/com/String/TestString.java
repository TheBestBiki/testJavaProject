package com.String;

import com.stream.TestClass;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2020/2/26
 */
public class TestString {

    public final static List<String> buyerList =  Arrays.asList("SCBUYER","11");

    public static void main(String[] args) {
        /*String time = "2020-09-22 12:08:57";
        System.out.println(time.substring(0,19));

        String ss = null;
        BigDecimal s = new BigDecimal(ss);
        System.out.println( s.toString());
        System.out.println( s.compareTo(new BigDecimal(0)) == 0);*/

        /*Byte aa = 2;
        //Integer ac = (int)aa;
        System.out.println(aa.equals((byte)2));

        Double d = 2d;
        System.out.println(d==2);*/

        /*Date date = new Date("2016-08-12 00:00:00");
        System.out.println(date);*/

        /*String ss = "动图大大22";
        System.out.println(ss.length());

        TestClass testClass = new TestClass();
        changeClass(testClass);
        System.out.println(testClass.toString());*/

        //testIndexOf();

        //testStringBuilderInsert();

        //test3Point("11","22");
    }

    /**
     * 可变长参数，就是这个位置可以传入任意个该类型参数
     * 简单来说就是个数组  像数组那样来使用就好了
     * @param args
     */
    private static void test3Point(String... args) {
        for(int i=0;i<args.length;i++){
            System.out.println(args[i]);
        }
        List<String> test = Arrays.asList(args);
        System.out.println(test.toString());
        System.out.println(args.getClass());
    }

    private static void testStringBuilderInsert() {
        StringBuilder errMsg = new StringBuilder();
        errMsg.append("0123456");
        errMsg.insert(0,"qqqq");
        System.out.println(errMsg.toString());
    }

    /**
     * 测试截取字符串的indexOf
     */
    private static void testIndexOf() {
        String aa = "ab^c";
        int a = aa.lastIndexOf("^");
        System.out.println(aa.lastIndexOf("^"));
        System.out.println(aa.substring(0,a));
    }

    private static void changeClass(TestClass testClass) {
        testClass.setPro1("1111");
    }


    //public static void main(String[] args) {
        /*
        String aa ="aa,bb";
        System.out.println(aa);
        String bb = aa.replaceAll(",",";");
        System.out.println(bb);
        */

        /*
        StringB b = new StringB();
        Long a = null;
        b.setAa(String.valueOf(a));
        System.out.println(b.getAa());
        */

        /*
        String strcreatDt ="sdadads";
        String queryBody="{'app_label': 'dim_product','model': 'blacklistdspn','start_at':'"+strcreatDt+"'}";
        System.out.println(queryBody);
        */

        /*
       StringB stringA = new StringB();
       System.out.println(stringA==null);//false
        */

       /*
       List list = new ArrayList<>();
       System.out.println(list.size());//0
       */

       /*
        List list =null;
        System.out.println(list.size());//报空指针
        */

       /*if("1".equals("2") || !(3==4)){
           System.out.println("成功");
       }*/

       /*Map<String,String> map =new HashMap<>();
       map.get("dfd");
       System.out.println("dfdsdfdf");*/

       /*Date date = new Date();
       System.out.println(date);*/

       /*Long aa = 1000000L;
       Long bb = 1024*1024*150L;
       if(aa>bb){
           System.out.println("aaaaa");
       }else{
           System.out.println(bb);
       }*/

       /*Map<String,String> map = new HashMap<>();
       System.out.println(map.get("fdfd"));
        Map<String,String> map1 = new HashMap<>();
        map1.put("11","222");
        map1.put("ffd","fdfd");
        System.out.println(map1.size());*/              //10000

        //每隔500执行插入
        /*for(int i=0;i<6219;i+=500){
            if(i>=6219){
                break;
            }
            for(int j=i;j<i+500;j++){
                if(j>=6219){
                    break;
                }
                System.out.println(j);
            }
        }*/

        //遍历set
        /*Set<String> set = new HashSet<String>(Arrays.asList("B_SUBSTITUTE_LIST"));
        //Set<String> set = new HashSet<String>();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String str = it.next();
            System.out.println(str+"...");
        }*/

        //若这里的StringB 不是对象，而是String的时候，则这里的循环无法改变lists中的元素的值
        /*List<StringB> lists = new ArrayList<>();
        lists.add(new StringB("11"));
        lists.add(new StringB("22"));

        for(StringB s :lists){
            s.setAa("aa");
        }
        System.out.println(lists.get(0).getAa()+"--"+lists.get(1).getAa());*/

        /*String aa="123|";
        System.out.println(aa.substring(0,aa.length()-1));*/

        //截取-拼接字符串
        /*List<String> bb=new ArrayList<>();
        bb.add("123");
        bb.add("456");
        String brandName="";
        for(String m : bb){
            brandName +=m+"|";
        }
        System.out.println(brandName.substring(0,brandName.length()-1));*/

        //int 转 long类型
       /* List<String> bb=new ArrayList<>();
        bb.add("123");
        bb.add("456");
        Long aa = (long)bb.size();
        System.out.println(aa);*/

       /*int a=2;
        for(int i=0;i<5;i++){
            System.out.println(i);
            if(i==a){
                continue;
            }
            System.out.println(i+"多的");
        }*/

       /*int i =2;
       int j=4;
       int k=i++ <--j && i<j ?(i+j) : (i-j);
       System.out.println(i+"-"+j+"-"+k);*/

       /*List<String> list1 = new ArrayList<>();
       List<String> list2 = new ArrayList<>();
       list1.add("11");
       list1.add("22");
       list2.add("33");
       list2.add("55");
       list2.add("11");
       //list1.retainAll(list2);
       //list1=list2;
        list1.clear();
       System.out.println(list1.toString());*/

       //写一个函数，返回一个数组中所有元素被第一个元素除的结果
       /*int[] aa = new int[]{4,3,2,1};
       for(int i=aa.length-1;i>=0;i--){
           aa[i] =aa[0]/aa[i];
           System.out.println(aa[i]);
       }
       Arrays.sort(aa);
       for(int i=0;i<aa.length;i++){
           System.out.print(aa[i]+" ");
       }*/

       //数组检验
        /*String aa[] = {"11","22","33"};
        for(String a : aa){
            if("22".equals(a)){
                break;
            }
            System.out.println(a);
        }*/

        /*String[] arrays={"11","22","33"};
        List<String> list = new ArrayList<>(Arrays.asList(arrays));*/

        /*List<String> list1 = new ArrayList<>();
        list1.add("11");
        list1.add("22");
        list1.add("33");
        list1.add("55");
        List<String> list2=list1.subList(1,3);
        for(String s:list2){
            System.out.println(s);
        }*/

        //list的指向地址问题
        /*List<String> a = new ArrayList<>(Arrays.asList("11","22","33"));
        List<String> b=a;
        List<String> c=new ArrayList<>();
        c.addAll(a);
        a.set(0,"111");//修改第一个元素
        System.out.println(a.toString());//[111, 22, 33]
        System.out.println(b.toString());//[111, 22, 33]
        System.out.println(c.toString());//[11, 22, 33]*/

        /*String bb= String.valueOf(100L);
        System.out.println(bb);*/

        /*String aa="asdf";
        System.out.println(Arrays.toString(aa.getBytes()));*/

        /*List<String> aa = new ArrayList<>(Arrays.asList("11"));
        List<String> bb = Arrays.asList("22","11","44");
        *//*aa.retainAll(bb);
        System.out.println(aa.toString()+"-------"+bb.toString());*//*

        List<String> userRoleCopy = new ArrayList<>();
        userRoleCopy.addAll(aa);
        //retainAll -> true是没有交集，false是有交集
        System.out.println(!userRoleCopy.retainAll(bb));*/

        /*List<String> roles=new ArrayList<>();
        roles.add("PPM_LEADER");
        roles.add("SCBUYER");
        roles.add("RiskBuy");
        System.out.println(checkUserRole(buyerList,roles));*/

        /*List<String> roles=new ArrayList<>();
        System.out.println(roles.size()); // 0
        System.out.println(roles.isEmpty()); //true*/

        /*
        String a = new String("123");
        String aa = "123";
        System.out.println(a.equals(aa));//true
        System.out.println(a==aa);//false
        */
    //}

    private static boolean checkUserRole(List<String> roleList, List<String> userRoleList){
        List<String> userRoleCopy = new ArrayList<>();
        userRoleCopy.addAll(userRoleList);
        userRoleCopy.retainAll(roleList);
        System.out.println(userRoleCopy.size());
        return userRoleCopy.size()==0? false:true;


    }

}
