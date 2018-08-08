package com.sauzny.jkitchen_note.db.es;

import java.util.ArrayList;
import java.util.List;

import com.sauzny.jkitchen_note.db.es.model.TradeRecord;


public class DataFactory {

	public static List<String> getInitJsonData(){
		

        List<String> list = new ArrayList<String>();
        String data1  = ESJsonUtil.tradeRecord2JsonData(new TradeRecord("3216549871", "马甲1", "321657471", "ze1236549877", "121", "21", "2015-02-12 00:00:01", "1"));
        String data2  = ESJsonUtil.tradeRecord2JsonData(new TradeRecord("3216549872", "马甲2", "321657472", "ze1236549877", "122", "22", "2015-02-12 00:00:02", "2"));
        String data3  = ESJsonUtil.tradeRecord2JsonData(new TradeRecord("3216549873", "马甲3", "321657473", "ze1236549877", "123", "23", "2015-02-12 00:00:03", "3"));
        String data4  = ESJsonUtil.tradeRecord2JsonData(new TradeRecord("3216549874", "马甲4", "321657474", "ze1236549877", "124", "24", "2015-02-12 00:00:04", "4"));
        String data5  = ESJsonUtil.tradeRecord2JsonData(new TradeRecord("3216549875", "马甲5", "321657475", "ze1236549877", "125", "25", "2015-02-12 00:00:05", "5"));
        list.add(data1);
        list.add(data2);
        list.add(data3);
        list.add(data4);
        list.add(data5);
		
		return list;
	}
}
