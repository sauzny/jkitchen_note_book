package com.sauzny.tooljdk.supplychar;

import java.text.MessageFormat;

/***************************************************************************
 *
 * @时间: 2019/1/30 - 14:25
 *
 * @描述: TODO
 *
 ***************************************************************************/
public class SupplyFormat {

    /**
     * 	方法描述:  左补位
     *
     *  @author  ljx 创建时间 2016年10月8日 上午11:18:47
     */
    public static String leftSupply(String sourceStr, int targetLen, char filterChar){
        return supplyString(true, sourceStr, genFiller(sourceStr.length(), targetLen, filterChar));
    }

    /**
     * 	方法描述:  右补位
     *
     *  @author  ljx 创建时间 2016年10月8日 上午11:19:16
     */
    public static String rightSupply(String sourceStr, int targetLen, char filterChar){
        return supplyString(false, sourceStr, genFiller(sourceStr.length(), targetLen, filterChar));
    }

    /**
     * 	方法描述:  生成填充字符串
     *
     *  @author  ljx 创建时间 2016年10月8日 上午11:19:32
     */
    public static String genFiller(int sourceLen, int targetLen, char filterChar){
        char[] cs = new char[targetLen-sourceLen];
        for(int i=0;i<cs.length;i++){
            cs[i] = filterChar;
        }
        return new String(cs);
    }

    /**
     * 	方法描述:  格式化字符串
     *
     *  @author  ljx 创建时间 2016年10月8日 上午11:19:55
     */
    public static String supplyString(boolean isLeft, String sourceStr, String filler){
        String msg = "";
        if(isLeft){
            msg = "{0}"+sourceStr;
        }else{
            msg = sourceStr+"{0}";
        }
        MessageFormat mf = new MessageFormat(msg);
        return mf.format(new Object[]{filler});
    }

    public static void main(String[] args) {
        String str = SupplyFormat.leftSupply("685", 8, '0');
        System.out.println(str);
    }
}

