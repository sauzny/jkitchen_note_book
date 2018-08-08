package com.sauzny.jkitchen_note.db.es;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;

import com.sauzny.jkitchen_note.db.es.model.Pagination;
import com.sauzny.jkitchen_note.db.es.model.TradeRecord;

public class MyES {

    public static final String ip = "192.168.10.58";
    public static final int host = 9300;
    public static final String clusterName = "trade_data_ex";
    public static final String indexName = "order_ex";
    public static final String type = TradeRecord.class.getSimpleName();
    
	public static void main(String[] args) {
		
		TradeRecordDaoES tradeRecordDaoES = new TradeRecordDaoES(ip, host, clusterName, indexName, type);
		
		
		tradeRecordDaoES.inesrt(DataFactory.getInitJsonData());
		
		TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery(TradeRecord.Field.productId.name(), "ze1236549877");
		FieldSortBuilder fieldSortBuilder = SortBuilders.fieldSort(TradeRecord.Field.payTimeLong.name()).order(SortOrder.DESC);
		Pagination pagination = new Pagination(10, 1);
		
		tradeRecordDaoES.searcher(termQueryBuilder, fieldSortBuilder, pagination);
		
	}
}
