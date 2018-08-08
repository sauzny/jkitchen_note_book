package com.sauzny.jkitchen_note.db.es;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.RangeFilterBuilder;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.springframework.stereotype.Repository;

import com.sauzny.jkitchen_note.db.es.model.Pagination;
import com.sauzny.jkitchen_note.db.es.model.TradeRecord;

@Repository
public class TradeRecordDaoES {

	private Client client;

	private String indexName = "no index name";
    
	private String type = "no type";
	
	@SuppressWarnings("resource")
	public TradeRecordDaoES(String ip, int host, String clusterName, String indexName, String type){
		
		this.indexName = indexName;
		this.type = type;
		
    	Settings settings = ImmutableSettings.settingsBuilder()
				.put("cluster.name", clusterName)
				.build();

		client = new TransportClient(settings)
					.addTransportAddress(new InetSocketTransportAddress(ip, host));
	}
	
	/**
	 * 批量增加
	 */
	public void inesrt(List<String> objJsonList){
        //创建索引库 需要注意的是.setRefresh(true)这里一定要设置,否则第一次建立索引查找不到数据
        IndexRequestBuilder requestBuilder = client.prepareIndex(indexName, type).setRefresh(true);
        for(int i=0; i<objJsonList.size(); i++){
        	requestBuilder.setSource(objJsonList.get(i)).execute().actionGet();
        }
	}
	
	/**
	 * 增加
	 */
	public IndexResponse insert(String objJson){
        IndexResponse response = client.prepareIndex(this.indexName, this.type)
                .setSource(objJson)
                .execute()
                .actionGet();
            return response;
	}
    
	/**
	 * 查询
	 */
	public List<TradeRecord> searcher(TermQueryBuilder termQueryBuilder,
			FieldSortBuilder fieldSortBuilder,
			RangeFilterBuilder rangeFilterBuilder,
			Pagination pagination) {

    	List<TradeRecord> tradeRecorList = new ArrayList<TradeRecord>();
    	
        //SearchResponse response = client.prepareSearch("index1", "index2")
        //.setTypes("type1", "type2")
    	SearchRequestBuilder searchRequestBuilder = client.prepareSearch(this.indexName).setTypes(this.type)
                					.setSearchType(SearchType.DFS_QUERY_THEN_FETCH);
        // Query
    	if(termQueryBuilder != null) searchRequestBuilder.setQuery(termQueryBuilder);
        // 排序
    	if(fieldSortBuilder != null) searchRequestBuilder.addSort(fieldSortBuilder);
        // Filter
    	if(rangeFilterBuilder != null) searchRequestBuilder.setPostFilter(rangeFilterBuilder); 
    	// 分页
    	if(pagination != null) searchRequestBuilder.setFrom((pagination.getCurrentPage()-1)*pagination.getNumPerPage())
    						.setSize(pagination.getNumPerPage())
    						.setExplain(true);
    	// 执行查询
        SearchResponse response = searchRequestBuilder.execute().actionGet();
        // 获取查询结果
        SearchHit[] searchHists = response.getHits().getHits();
        
        //组织返回结果
        if(searchHists.length>0){
            for(SearchHit hit:searchHists){
            	
            	String orderId = (String)hit.getSource().get(TradeRecord.Field.orderId.name());
                String userName =  (String) hit.getSource().get(TradeRecord.Field.userName.name());
                String payTime =  (String) hit.getSource().get(TradeRecord.Field.payTime.name());
                String receiveMobile =  (String) hit.getSource().get(TradeRecord.Field.receiveMobile.name());
                String productId =  (String) hit.getSource().get(TradeRecord.Field.productId.name());
                String curPrice =  (String) hit.getSource().get(TradeRecord.Field.curPrice.name());
                String count =  (String) hit.getSource().get(TradeRecord.Field.count.name());
                String payTimeLong =  (String) hit.getSource().get(TradeRecord.Field.payTimeLong.name());
                
                TradeRecord tradeRecord = new TradeRecord(orderId, userName, receiveMobile, productId, curPrice, count, payTime, payTimeLong);
            	tradeRecorList.add(tradeRecord);
            }
        }
        
        return tradeRecorList;
    	
    }
    
	/**
	 * 查询
	 */
    public List<TradeRecord> searcher(TermQueryBuilder termQueryBuilder,
			FieldSortBuilder fieldSortBuilder,
			Pagination pagination){
    	return this.searcher(termQueryBuilder, fieldSortBuilder, null, pagination);
    }


}
