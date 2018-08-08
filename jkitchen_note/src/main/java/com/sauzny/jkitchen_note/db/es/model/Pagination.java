package com.sauzny.jkitchen_note.db.es.model;

/**
 * *************************************************************************
 * @文件名称: Pagination.java
 *
 * @包路径  : com.es 
 *				 
 * @版权所有: xxx888（北京）科技有限公司 (C) 2014
 *
 * @类描述:  页码
 * 
 * @创建人:   liujinxin  
 *
 * @创建时间: 2015年3月29日 - 上午10:59:52 
 *
 * @修改记录:
   -----------------------------------------------------------------------------------------------
             时间						|		修改人		|		修改的方法		|		修改描述                                                                
   -----------------------------------------------------------------------------------------------
							|					|					|                                       
   ----------------------------------------------------------------------------------------------- 	
 
 **************************************************************************
 */
public class Pagination {

	public Pagination(int numPerPage, int currentPage){
		this.numPerPage = numPerPage;
		this.currentPage = currentPage;
	}
	
	//总记录数
	private int totalCount;
	
	//总页数
	private int pageNumCount;
	
	//每页记录数
	private int numPerPage;
	
	//当前页数
	private int currentPage;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageNumCount() {
		return pageNumCount;
	}

	public void setPageNumCount(int pageNumCount) {
		this.pageNumCount = pageNumCount;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	
}
