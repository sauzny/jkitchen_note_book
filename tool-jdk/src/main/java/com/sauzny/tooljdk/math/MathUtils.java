package com.sauzny.tooljdk.math;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/***************************************************************************
 *
 * @时间: 2019/1/30 - 14:23
 *
 * @描述: TODO
 *
 ***************************************************************************/
public class MathUtils {
    /**
     * 	方法描述:  中位数
     *
     *  @author  ljx 创建时间 2017年7月25日 下午2:39:23
     */
    public static int medianNum(Integer[] nums){

        List<Integer> list = Arrays.asList(nums);
        Collections.sort(list);

        int size = list.size();

        if (size%2 == 0){
            return list.get(size/2);
        }else{
            return list.get(size+1/2);
        }

    }
}
