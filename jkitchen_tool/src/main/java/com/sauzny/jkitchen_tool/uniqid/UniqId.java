package com.sauzny.jkitchen_tool.uniqid;

import com.sauzny.jkitchen_tool.supplychar.SupplyFormat;

/**
 * *************************************************************************
 * @文件名称: UniqId.java
 *
 * @包路径  : com.sauzny.javaknife.uniqid 
 *				 
 * @版权所有: Personal liujinxin (C) 2016
 *
 * @类描述:  唯一id生成
 * 
 * @创建人:   ljx 
 *
 * @创建时间: 2016年10月8日 - 下午1:51:58 
 *	
 **************************************************************************
 */
public class UniqId {

    /**
     * 	方法描述:  认为每秒最多需要10000个id，生成唯一id
     *   
     *  @author  ljx 创建时间 2016年10月8日 下午1:52:11
     */
    public static String genIdPerSecond(){
        
        String id = "";
        
        // 当前时间举例
        String preDate = "20161008143756";
        
        // 1.7 api 使用
        id = preDate + SupplyFormat.leftSupply(AtomicLongId.genIdLimit10000(), 5, '0');
        
        // 1.8 api 使用
        id = preDate + SupplyFormat.leftSupply(LongAdderId.genIdLimit10000(), 5, '0');
        
        return id;
    }
    
}
