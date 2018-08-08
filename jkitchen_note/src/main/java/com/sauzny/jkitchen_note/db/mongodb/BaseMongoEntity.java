package com.sauzny.jkitchen_note.db.mongodb;

public class BaseMongoEntity {

	public BaseMongoEntity(){
		
	}
	
	public BaseMongoEntity(String id){
		this.id = id;
	}
	
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
