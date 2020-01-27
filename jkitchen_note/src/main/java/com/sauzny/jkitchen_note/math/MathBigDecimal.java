package com.sauzny.jkitchen_note.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.lang.System.out;

public class MathBigDecimal {
    
    public static void main(String[] args) {
        
        double d = 5.34375;
        System.out.println(Long.toBinaryString(Double.doubleToLongBits(d)));
        
        System.out.println(Long.MAX_VALUE);
        
        Double doubleObject = 2147483648d;
        System.out.println(doubleObject.longValue());
        System.out.println(doubleObject.intValue());
        System.out.println(doubleObject.shortValue());
        System.out.println(doubleObject.byteValue());

        byte b = (byte) 2147483647;
        System.out.println(b);
        
        BigDecimal num1 = new BigDecimal("100");  
        BigDecimal num2 = new BigDecimal("50");  
        
        //加法
        BigDecimal result1 = num1.add(num2);
        out.println("和    是   :  " + result1);
        
        //减法 
        BigDecimal result2 = num1.subtract(num2);
        out.println("差    是   :  " + result2);
        
        //乘法
        BigDecimal result3 = num1.multiply(num2);
        out.println("积    是   :  " + result3);
        
        //除法
        // 四舍五入 RoundingMode.HALF_UP
        BigDecimal result4 = num1.divide(num2, RoundingMode.HALF_UP);
        out.println("商    是   :  " + result4);
        
        // 可以设置保留几位小数，向上取整等
        // 保留小数现在使用新的类 RoundingMode
        // b1.divide(b2,2, BigDecimal.ROUND_HALF_UP)
        
        //比较
        BigDecimal num = new BigDecimal("100");     //用做比较的值  
        out.println(num1.compareTo(num2));            //大于 时，返回 1 
        out.println(num.compareTo(num1));            //等于 时，返回 0  
        out.println(num2.compareTo(num1));            //小于 时，返回 -1
        
        out.println(num1.min(num2));                //求两个数的最小值,返回小的数
        out.println(num1.max(num2));                //求两个数的最大值,返回大的数

        /**
         *ROUND_CEILING*
         Rounding mode to round towards positive infinity.
         向正无穷方向舍入

         *ROUND_DOWN*
         Rounding mode to round towards zero.
         向零方向舍入

         *ROUND_FLOOR*
         Rounding mode to round towards negative infinity.
         向负无穷方向舍入

         *ROUND_HALF_DOWN*
         Rounding mode to round towards "nearest neighbor" unless both neighbors are equidistant, in which case round down.
         向（距离）最近的一边舍入，除非两边（的距离）是相等,如果是这样，向下舍入, 例如1.55 保留一位小数结果为1.5

         *ROUND_HALF_EVEN*
         Rounding mode to round towards the "nearest neighbor" unless both neighbors are equidistant, in which case, round towards the even neighbor.
         向（距离）最近的一边舍入，除非两边（的距离）是相等,如果是这样，如果保留位数是奇数，使用ROUND_HALF_UP ，如果是偶数，使用*ROUND_HALF_DOWN*


         *ROUND_HALF_UP*
         Rounding mode to round towards "nearest neighbor" unless both neighbors are equidistant, in which case round up.
         向（距离）最近的一边舍入，除非两边（的距离）是相等,如果是这样，向上舍入, 1.55保留一位小数结果为1.6


         *ROUND_UNNECESSARY*
         Rounding mode to assert that the requested operation has an exact result, hence no rounding is necessary.
         计算结果是精确的，不需要舍入模式


         *ROUND_UP*
         Rounding mode to round away from zero.
         向远离0的方向舍入
         */

//        compareTo方法比较时,不同于equals方法,需要两边都不为null,否则会报空指针异常,
//        源码如下
//        public int compareTo(BigDecimal val) {
//            // Quick path for equal scale and non-inflated case.
//            if (scale == val.scale) {
//                long xs = intCompact;
//                long ys = val.intCompact;
//                if (xs != INFLATED && ys != INFLATED)
//                    return xs != ys ? ((xs > ys) ? 1 : -1) : 0;
//            }
//            int xsign = this.signum();
//            int ysign = val.signum();
//            if (xsign != ysign)
//                return (xsign > ysign) ? 1 : -1;
//            if (xsign == 0)
//                return 0;
//            int cmp = compareMagnitude(val);
//            return (xsign > 0) ? cmp : -cmp;
//        }

//        max/min方法源代码如下
//        public BigDecimal max(BigDecimal val) {
//            return (compareTo(val) >= 0 ? this : val);
//        }
//        public BigDecimal min(BigDecimal val) {
//            return (compareTo(val) <= 0 ? this : val);
//        }
    }

    
}
