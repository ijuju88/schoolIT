package controllerAction;

public class PageMaker {
	private int pageSize=3,totalCount,startPage,endPage,currentPage=1,start;
	private boolean prev, next;
	
	public PageMaker(int currentPage, int totalCount) {
		this.currentPage=currentPage;
		this.totalCount=totalCount;
		
		start=(currentPage-1)*pageSize;
		
		System.out.println(Math.ceil(totalCount/(double)pageSize));
		
		endPage=(int)(Math.ceil(currentPage/(double)pageSize)*pageSize);
		startPage=(endPage-pageSize)+1;
		int totalPage=(int)(Math.ceil(totalCount/(double)pageSize));
		
		if(endPage>totalPage){endPage=totalPage;}
		
		prev=startPage==1?false:true;
		next=endPage>=totalPage?false:true;
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

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public boolean getPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean getNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}
	
	
}
