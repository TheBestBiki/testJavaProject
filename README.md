### Git导入项目失败时的解决办法：
    参考网址：https://blog.csdn.net/m0_37961948/article/details/78161828
    主要做法：
    1.删除 .idea文件夹下面的modules.xml文件的<module>标签这一行
    2.右键项目，选择Build module '项目名'
    3.File -> project structure... ,给project选项配置好jdk，以及output目录；然后选择modules,选择sources,然后点击src，
    再点击蓝色的sources，这时右边会多出蓝色的src相关的字，就可以了。 保存，ok就可以运行了。
    
# 自20210310起写的记录
    测试了字符串转byte数组时数据的存储情况，包括原码，反码，补码等
    com.byteTest.ByteTest.testByteSave
    
# KMP算法
    com.algorithm.KMPTest