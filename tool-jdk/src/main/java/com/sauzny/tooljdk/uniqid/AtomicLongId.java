package com.sauzny.tooljdk.uniqid;

import java.util.concurrent.atomic.AtomicLong;

/**
 * *************************************************************************
 * @文件名称: AtomicLongId.java
 *				 
 * @版权所有: Personal liujinxin (C) 2016
 *
 * @类描述:  AtomicLong生成唯一id
 * 
 * @创建人:   ljx 
 *
 * @创建时间: 2016年10月8日 - 上午11:36:19 
 *	
 **************************************************************************
 */
public class AtomicLongId {

    private static final AtomicLong lastId = new AtomicLong(0L);
    
    public static String genId() {
        return String.valueOf(lastId.incrementAndGet());
    }
    
    /**
     * 	方法描述:  id、有最大上限，达到最大上限的时候，重置lastId为0，再获取id，即id的范围是[1,max]
     *   
     *  @author  ljx 创建时间 2016年10月8日 下午2:22:36
     */
    public static String genIdLimited(long max) {
        if(lastId.get() >= max){
            lastId.set(0);
        }
        return genId();
    }

    public static String genIdLimit10000(){
        return genIdLimited(10000L);
    }
}
