package com.sauzny.jkitchen_note.db.myhbase;

public class CommonReq {

	private String userName;
	
	private String customSql;

	private String rubik;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCustomSql() {
		return customSql;
	}

	public void setCustomSql(String customSql) {
		this.customSql = customSql;
	}

	public String getRubik() {
		return rubik;
	}

	public void setRubik(String rubik) {
		this.rubik = rubik;
	}
	
	
}
