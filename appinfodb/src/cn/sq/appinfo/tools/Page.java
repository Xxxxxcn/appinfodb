package cn.sq.appinfo.tools;

import java.util.List;

public class Page {
	
	//初始页
	private int pageInex=1; 
	//总页面
	private int pageTotal;
	// 每页显示记录的条数  
	private int pageSize = 5;
	//总数量
	private int totalCount;
	//存储分页数据
	private List list;
	
	public int getPageInex() {
		return pageInex;
	}
	public void setPageInex(int pageInex) {
		this.pageInex = pageInex;
	}
	public int getPageTotal() {
		pageTotal = getTotalCount() / getPageSize();
		return (totalCount % pageSize == 0) ? pageTotal : pageTotal + 1;
	}
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Page(int pageInex, int pageTotal, int pageSize, int totalCount, List list) {
		super();
		this.pageInex = pageInex;
		this.pageTotal = pageTotal;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.list = list;
	}
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//当前页
	public int getCurrentpage() {
		return (pageInex - 1) * pageSize;
	}
	
	//上一页
	public int getPreviouspage() {
		return (getPageSize() < 1) ? pageSize = 1 : pageSize - 1;
	}
	//下一页
	public int getNextpage() {
		return (getPageSize() > getPageTotal()) ? pageSize = getPageTotal() : pageSize + 1;
	}
	
}
