package com.iu.s1.util;

public class Pagination {

	//한페이지에 출력할 row의 갯수
	private Long perPage;
	
	//Client가 보고싶은 페이지 번호(parameter)
	private Long page;
	
	//table에서 조회할 시작번호
	private Long startRow;
	
	//table에서 조회할 끝번호
	private Long lastRow;
	
	//startRow, lastRow 계산하는 메서드
	public void makeRow() {
		
		this.startRow = (this.getPage()-1)*this.getPerPage()+1;
		this.lastRow = this.getPage()*this.getPerPage();
		
	}

	public Long getPerPage() {
		return perPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}

	public Long getPage() {
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public Long getStartRow() {
		return startRow;
	}

	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}

	public Long getLastRow() {
		return lastRow;
	}

	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	
}
