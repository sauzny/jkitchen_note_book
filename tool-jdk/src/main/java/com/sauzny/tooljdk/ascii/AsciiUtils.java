package com.sauzny.tooljdk.ascii;

/***************************************************************************
 *
 * @时间: 2019/1/30 - 13:33
 *
 * @描述: TODO
 *
 ***************************************************************************/
public class AsciiUtils {
    public static void main(String[] args) {

        String2ASCII("A");
        ASCII2String("65");

    }

    /**
     *  Function:
     *  功能说明：
     *	 使用说明：
     *  @author  liujinxin  DateTime 2014年6月3日 上午11:15:31
     *	 返回类型: void
     *  @param ASCII
     */
    public static void ASCII2String(String ASCII) {// ASCII转换为字符串


        String[] chars = ASCII.split(" ");
        System.out.println("ASCII 汉字 \n----------------------");
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i] + " "
                    + (char) Integer.parseInt(chars[i]));
        }
    }

    /**
     *  Function:
     *  功能说明：
     *	 使用说明：
     *  @author  liujinxin  DateTime 2014年6月3日 上午11:15:02
     *	 返回类型: void
     *  @param str		字符串
     */
    public static void String2ASCII(String str) {// 字符串转换为ASCII码

        char[] chars = str.toCharArray(); // 把字符中转换为字符数组

        System.out.println("\n\n汉字 ASCII\n----------------------");
        for (int i = 0; i < chars.length; i++) {// 输出结果

            System.out.println(" " + chars[i] + " " + (int) chars[i]);
        }
    }
}
