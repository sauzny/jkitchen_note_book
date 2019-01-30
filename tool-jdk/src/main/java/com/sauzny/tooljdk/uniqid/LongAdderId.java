package com.sauzny.tooljdk.uniqid;

import java.util.concurrent.atomic.LongAdder;

/**
 * *************************************************************************
 * @文件名称: LongAdderId.java
 *				 
 * @版权所有: Personal liujinxin (C) 2016
 *
 * @类描述:  LongAdder生成唯一id，1.8版本之后的工具类
 * 
 * @创建人:   ljx 
 *
 * @创建时间: 2016年10月8日 - 下午2:40:54 
 *	
 **************************************************************************
 */
public class LongAdderId {

    private static final LongAdder lastId = new LongAdder();
    
    public static String genId() {
        lastId.increment();
        return String.valueOf(lastId.longValue());
    }
    
    /**
     * 	方法描述:  id、有最大上限，达到最大上限的时候，重置lastId为0，再获取id，即id的范围是[1,max]
     *   
     *  @author  ljx 创建时间 2016年10月8日 下午2:26:21
     */
    public static String genIdLimited(long max) {
        if(lastId.longValue() >= max){
            lastId.reset();
        }
        return genId();
    }

    public static String genIdLimit10000(){
        return genIdLimited(10000L);
    }
}
