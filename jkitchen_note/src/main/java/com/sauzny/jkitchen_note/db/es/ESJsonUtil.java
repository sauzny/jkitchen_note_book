package com.sauzny.jkitchen_note.db.es;

import java.io.IOException;

import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

import com.sauzny.jkitchen_note.db.es.model.TradeRecord;

public class ESJsonUtil {
	
	public static String tradeRecord2JsonData(TradeRecord tradeRecord){
		
        String jsonData = null;
        try {
            //使用XContentBuilder创建json数据
            XContentBuilder jsonBuild = XContentFactory.jsonBuilder();
            jsonBuild.startObject()
            .field("orderId",tradeRecord.getOrderId())
            .field("userName", tradeRecord.getUserName())
            .field("receiveMobile",tradeRecord.getReceiveMobile())
            .field("productId",tradeRecord.getProductId())
            .field("curPrice",tradeRecord.getCurPrice())
            .field("count",tradeRecord.getCount())
            .field("payTime",tradeRecord.getPayTime())
            .field("payTimeLong",tradeRecord.getPayTimeLong())
            .endObject();
            jsonData = jsonBuild.string();
//            System.out.println(jsonData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return jsonData;
    }
	
}
