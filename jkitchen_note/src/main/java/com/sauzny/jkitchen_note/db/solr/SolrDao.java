package com.sauzny.jkitchen_note.db.solr;

import java.io.IOException;


import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.CloudSolrServer;

import javax.annotation.PostConstruct;

public class SolrDao {

	
	@PostConstruct
	public void init(){
	}
	
	public int insert(Object obj){
		
		int result = 0;
		
		try {
			SolrServer solrServer = new CloudSolrServer("http://192.168.208.119:8389/solr");
			solrServer.addBean(obj);
			solrServer.commit();
			result = 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return result;
	}
}
