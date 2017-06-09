package compsg.cn.msgboard.utils;

public class PageUtil {
	
	//当前页，默认为1
	private int pageNow = 1;
	//每页的记录行数
	private int pageSize = 5;
	//分页的总数
	private int pageCount;
	//记录的总行数
	private int rowCount;
	//下一页的页码
	private int nextPage;
	//上一页的页码
	private int prevPage;
	//第一页的页码
	private int startPage = 1;
	//最后一页的页码
	private int endPage;
	
	//构造函数，初始化每页大小，总行数，当前页面，总页数，下一页，前一页和最后一页
	public PageUtil(Integer pageSize, int rowCount, String str_pageNow){
		
		if(str_pageNow != null)
			this.pageNow = Integer.parseInt(str_pageNow);
			
		if(pageSize != null){
			this.pageSize = pageSize;
		}
		else
			pageSize = this.pageSize;
		
		this.pageCount = (rowCount % pageSize == 0) ? (rowCount / pageSize) : ((rowCount / pageSize) + 1);
		this.nextPage = (this.pageCount != 0) ? (Math.min(this.pageCount, this.pageNow + 1)) : this.pageNow;
		this.prevPage = Math.max(1, this.pageNow - 1);
		this.endPage = this.pageCount;
		
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
}
