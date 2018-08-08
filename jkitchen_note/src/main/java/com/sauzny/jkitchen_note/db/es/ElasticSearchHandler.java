package com.sauzny.jkitchen_note.db.es;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;

import com.sauzny.jkitchen_note.db.es.model.TradeRecord;

public class ElasticSearchHandler {


    public static final String indexname = "ljxtest1";
    public static final String type = TradeRecord.class.getSimpleName();
	
    private Client client;

    public ElasticSearchHandler(){    
        //使用192.168.10.58做为节点
        this("192.168.48.128");
    }
    
    public ElasticSearchHandler(String ipAddress){
        //集群连接超时设置
        /*  
              Settings settings = ImmutableSettings.settingsBuilder().put("client.transport.ping_timeout", "10s").build();
            client = new TransportClient(settings);
         */
    	Settings settings = ImmutableSettings.settingsBuilder()
    						//.put("xiaojingjing", "nvhaizi")
    						.put("cluster.name", "nvhaizi")
    						.build();
    	
        client = new TransportClient(settings)
        	.addTransportAddress(new InetSocketTransportAddress(ipAddress, 9300));
    }
    
    
    /**
     * 建立索引,索引建立好之后,会在elasticsearch-0.20.6\data\elasticsearch\nodes\0创建所以你看
     * @param indexName  为索引库名，一个es集群中可以有多个索引库。 名称必须为小写
     * @param indexType  Type为索引类型，是用来区分同索引库下不同类型的数据的，一个索引库下可以有多个索引类型。
     * @param jsondata     json格式的数据集合
     * 
     * @return
     */
    public void createIndexResponse(String indexname, String type, List<String> jsondata){
        //创建索引库 需要注意的是.setRefresh(true)这里一定要设置,否则第一次建立索引查找不到数据
        IndexRequestBuilder requestBuilder = client.prepareIndex(indexname, type).setRefresh(true);
        for(int i=0; i<jsondata.size(); i++){
        	// Index name
        	IndexResponse response = requestBuilder.setSource(jsondata.get(i)).execute().actionGet();
        	
            String _index = response.getIndex();
         // Type name
         String _type = response.getType();
         // Document ID (generated or not)
         String _id = response.getId();
         // Version (if it's the first time you index this document, you will get: 1)
         long _version = response.getVersion();
         /*
         System.out.println(_index);
         System.out.println(_type);
         System.out.println(_type);
         System.out.println(_version);
         */
        }     
        
        
         
    }
    
    /**
     * 创建索引
     * @param client
     * @param jsondata
     * @return
     */
    public IndexResponse createIndexResponse(String indexname, String type,String jsondata){
        IndexResponse response = client.prepareIndex(indexname, type)
            .setSource(jsondata)
            .execute()
            .actionGet();
        return response;
    }
    
    /**
     * 执行搜索
     * @param queryBuilder
     * @param indexname
     * @param type
     * @return
     */
    /*
    public List<TradeRecord>  searcher(QueryBuilder queryBuilder, String indexname, String type){
        List<TradeRecord> list = new ArrayList<TradeRecord>();
        SearchResponse searchResponse = client.prepareSearch(indexname).setTypes(type)
        .setQuery(queryBuilder)
        .execute()
        .actionGet();
        SearchHits hits = searchResponse.getHits();
        System.out.println("查询到记录数=" + hits.getTotalHits());
        SearchHit[] searchHists = hits.getHits();
        if(searchHists.length>0){
            for(SearchHit hit:searchHists){
                Integer id = (Integer)hit.getSource().get("id");
                String name =  (String) hit.getSource().get("name");
                String function =  (String) hit.getSource().get("funciton");
                list.add(new TradeRecord(id, name, function));
            }
        }
        return list;
    }
    */
    
    public List<TradeRecord>  searcher(String indexname, String type){
    	
        List<TradeRecord> list = new ArrayList<TradeRecord>();
        //SearchResponse response = client.prepareSearch("index1", "index2")
        SearchResponse response = client.prepareSearch(ElasticSearchHandler.indexname)
        		.setTypes(ElasticSearchHandler.type)
                //.setTypes("type1", "type2")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                // Query
                .setQuery(QueryBuilders.termQuery(TradeRecord.Field.productId.name(), "ze1236549877"))
                //排序
                .addSort(SortBuilders.fieldSort(TradeRecord.Field.payTimeLong.name()).order(SortOrder.DESC))
                // Filter
               // .setPostFilter(FilterBuilders.rangeFilter("age").from(12).to(18))   
                .setFrom(0).setSize(15).setExplain(true)
                .execute()
                .actionGet();
        SearchHit[] searchHists = response.getHits().getHits();
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
                
            	System.out.println(new TradeRecord(orderId, userName, receiveMobile, productId, curPrice, count, payTime, payTimeLong));
            }
        }
        return list;
    	
    }
    
    
    public static void main(String[] args) {
        ElasticSearchHandler esHandler = new ElasticSearchHandler();
        List<String> jsondata = DataFactory.getInitJsonData();
        //测试数据
       // List<String> jsondata = new ArrayList<String>();
        
        //esHandler.createIndexResponse(ElasticSearchHandler.indexname, ElasticSearchHandler.type, jsondata);
        
        
        esHandler.searcher(ElasticSearchHandler.indexname, ElasticSearchHandler.type);
        
        /*
        
        //查询条件
        QueryBuilder queryBuilder = QueryBuilders.fieldQuery("name", "感冒");
        QueryBuilder queryBuilder = QueryBuilders.boolQuery()
          .must(QueryBuilders.termQuery("id", 1));
        List<TradeRecord> result = esHandler.searcher(queryBuilder, indexname, type);
        
        for(int i=0; i<result.size(); i++){
            TradeRecord tradeRecord = result.get(i);
           // System.out.println("(" + tradeRecord.getId() + ")药品名称:" +tradeRecord.getName() + "\t\t" + tradeRecord.getFunction());
        }
        */
    }
}
