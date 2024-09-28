package org.example.lab.jdk21;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

//import static java.lang.StringTemplate.RAW;
//import static java.lang.StringTemplate.STR;

/**
 String Templates(字符串模板) 目前仍然是 JDK 21 中的一个预览功能。



 */

public class Solution430 {
    public static void main(String[] args) {

        String name = "Lokesh";

        /**
         * Java 目前支持三种模板处理器：
         *
         * STR：自动执行字符串插值，即将模板中的每个嵌入式表达式替换为其值（转换为字符串）。
         * FMT：和 STR 类似，但是它还可以接受格式说明符，这些格式说明符出现在嵌入式表达式的左边，用来控制输出的样式。
         * RAW：不会像 STR 和 FMT 模板处理器那样自动处理字符串模板，而是返回一个 StringTemplate 对象，这个对象包含了模板中的文本和表达式的信息。
         *
         * JDK 自带的三种模板处理器外，
         * 你还可以实现 StringTemplate.Processor 接口来创建自己的模板处理器，
         * 只需要继承 StringTemplate.Processor接口，然后实现 process 方法即可。
         */
        /*
        //STR
        String message1 = STR."Greetings \{name}.";

        //FMT
        String message2 = STR."Greetings %-12s\{name}.";

        //RAW
        StringTemplate st = RAW."Greetings \{name}.";
        String message3 = STR.process(st);
        */


        // 使用局部变量、静态/非静态字段甚至方法作为嵌入表达式：
        /*
        //variable
        message = STR."Greetings \{name}!";

        //method
        message = STR."Greetings \{getName()}!";

        //field
        message = STR."Greetings \{this.name}!";
        */

        // 表达式中执行计算并打印结果
        /*
        int x = 10, y = 20;
        String s = STR."\{x} + \{y} = \{x + y}";  //"10 + 20 = 30"
        */

        // 为了提高可读性，我们可以将嵌入的表达式分成多行:
        /*
        String time = STR."The current time is \{
                //sample comment - current time in HH:mm:ss
                DateTimeFormatter
                        .ofPattern("HH:mm:ss")
                        .format(LocalTime.now())
                }.";
        */
    }
}
