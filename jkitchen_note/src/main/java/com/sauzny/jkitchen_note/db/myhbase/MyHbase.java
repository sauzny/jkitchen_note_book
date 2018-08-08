package com.sauzny.jkitchen_note.db.myhbase;

import java.io.File;
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.HTablePool;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;

public class MyHbase {
	
	public void createTable(){
		
	}
	
	public static void main(String[] args) {
		
		ResultScanner scanner = null;
		
		try {
			System.getProperties().put("hadoop.home.dir", "E:/Program Files/hadoop-common-2.2.0-bin-master");
			
			Configuration conf = HBaseConfiguration.create();
			//conf.addResource("hbase/hbase-site.xml");
			conf.set("hbase.master", "192.168.48.128:60000");
			//conf.set("hbase.master", "192.168.0.201:60000");
			conf.set("hbase.zookeeper.quorum","192.168.48.128,192.168.48.134,192.168.48.135");  
			conf.set("hbase.zookeeper.property.clientPort", "2181");    
			  
			String tableName = "myHBaseTable";
			
			HTablePool pool = new HTablePool(conf, 1000); 
			HTableInterface table = pool.getTable(tableName);
			
			//HTable table = new HTable(conf, "myHBaseTable");
			
			
			
			Put p = new Put(Bytes.toBytes("myRow"));
			p.add(Bytes.toBytes("myFamily"), Bytes.toBytes("someQualifier"), Bytes.toBytes("Some Value"));
			
			table.put(p);
			
			Get g = new Get(Bytes.toBytes("myRow"));
			Result r = table.get(g);
			byte[] value = r.getValue(Bytes.toBytes("myFamily"),
					Bytes.toBytes("someQualifier"));
			String valueStr = Bytes.toString(value);
			System.out.println("-------------------------------------------GET: " + valueStr);
	
			Scan s = new Scan();
			s.addColumn(Bytes.toBytes("myFamily"), Bytes.toBytes("someQualifier"));
			scanner = table.getScanner(s);
			
			for (Result rr : scanner) {
				System.out.println("-------------------------------------------Found row: " + rr);
			}
			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			if(scanner != null){
				scanner.close();
			}
		}
	}
}
