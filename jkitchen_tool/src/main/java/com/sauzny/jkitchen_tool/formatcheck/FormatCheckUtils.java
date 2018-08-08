package com.sauzny.jkitchen_tool.formatcheck;

import java.io.File;
import java.util.List;
import java.util.regex.Pattern;

import com.google.common.collect.Lists;

public final class FormatCheckUtils {

    private FormatCheckUtils(){}
    
    
    /**
     * 运营商号段如下：
     * 中国联通号码：130、131、132、145（无线上网卡）、155、156、185（iPhone5上市后开放）、186、176（4G号段）、
     *               175（2015年9月10日正式启用，暂只对北京、上海和广东投放办理）
     * 中国移动号码：134、135、136、137、138、139、147（无线上网卡）、150、151、152、157、158、159、182、183、187、188、178
     * 中国电信号码：133、153、180、181、189、177、173、149 虚拟运营商：170、1718、1719 
     * 手机号前3位的数字包括：
     * 1 :1
     * 2 :3,4,5,7,8
     * 3 :0,1,2,3,4,5,6,7,8,9 
     * 总结： 目前java手机号码正则表达式有：
     * a :"^1[3|4|5|7|8][0-9]\\d{4,8}$"    一般验证情况下这个就可以了
     * b :"^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$"
     * Pattern和Matcher详解（字符串匹配和字节码）http://blog.csdn.net/u010700335/article/details/44616451
     */
    
    public static boolean isPhone(String phone){
        
        boolean isPhone = false;
        
        String regex = "^1[3|4|5|7|8][0-9]\\d{4,8}$";
        //String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
        
        if(phone.length() == 11 && Pattern.compile(regex).matcher(phone).matches()){
            isPhone = true;
        }
        
        return isPhone;
    }
    
    public static boolean isLengthRange(String str, int min, int max){
        return str.length() >= min && str.length() <= max;
    }
    
    public static boolean isSpecialChar(CharSequence str) {
        String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        return Pattern.compile(regEx).matcher(str).find();
    }
    
    public static boolean isUpChar(String str) {
        String regEx = "[A-Z]";
        return Pattern.compile(regEx).matcher(str).find();
    }
    
    public static boolean isLowChar(String str) {
        String regEx = "[a-z]";
        return Pattern.compile(regEx).matcher(str).find();
    }
    
    public static boolean isNumberChar(String str) {
        String regEx = "[0-9]";
        return Pattern.compile(regEx).matcher(str).find();
    }
    
    public static boolean isPwd3(String password){
        
        boolean isPwd3 = false;
        
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
        
        for(int i=0; i<password.length(); i++){
            Character c = password.charAt(i);
            if(isSpecialChar(c.toString())) r1 = 1;
            if(isUpChar(c.toString())) r2 = 1;
            if(isLowChar(c.toString())) r3 = 1;
            if(isNumberChar(c.toString())) r4 = 1;
        }
        
        if(r1+r2+r3+r4 >= 3){
            isPwd3 = true;
        }
        
        return isPwd3;
    }
    
    public static void main(String[] args) {
        
        List<String> words = Lists.newArrayList("28349274", "aaaaaa", "BBBBBB","idsfIHISD348702", "ivu4857$#^&^_", "46gioUFCA^%&");
        
        words.forEach(word -> {
            long a = System.currentTimeMillis();
            boolean isPwd3 = FormatCheckUtils.isPwd3(word);
            long b = System.currentTimeMillis();
            System.out.println(word + " - " + (b-a) + " - " + isPwd3);
        });
        
        
        System.out.println(isPhone("13634557676"));
        
        System.out.println(isLengthRange("13634557676", 4 ,20));
        
        System.out.println(File.separator);
    }
}
