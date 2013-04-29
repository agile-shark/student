package cn.edu.ccdx.student.util;

public class Pager {

	private Integer offset = new Integer(0);
	private Integer maxPageItems = new Integer(3); 
	private Integer maxIndexPages = new Integer(10);
	private Integer items = new Integer(0); 

	public Integer getItems() {
		return items;
	}

	public void setItems(Integer items) {
		this.items = items;
	}

	public Integer getMaxIndexPages() {
		return maxIndexPages;
	}

	public void setMaxIndexPages(Integer maxIndexPages) {
		this.maxIndexPages = maxIndexPages;
	}

	public Integer getNoncePage() {
		int page = offset / maxPageItems + 1;
		return page;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Integer getMaxPageItems() {
		return maxPageItems;
	}

	public void setMaxPageItems(Integer maxPageItems) {
		this.maxPageItems = maxPageItems;
	}

	public int getNumber() {
		int number = items - maxPageItems * (getNoncePage() - 1);
		return number;
	}

	public int getMaxPageNumber() {
		int maxPage = items / maxPageItems;
		if (maxPage == 0) {
			return maxPage;
		} else {
			return maxPage + 1;
		}
	}
}
