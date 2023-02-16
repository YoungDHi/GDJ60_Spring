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
	
	//page의 시작 번호
	private Long startNum;
	
	//page의 끝 번호
	private Long lastNum;
	
	//마지막 블럭이 perBlock일때
	private boolean after;
	
	//첫 블럭이 perBlocl일때
	private boolean before;
	
	//startRow, lastRow 계산하는 메서드
	public void makeRow() {
		
		this.startRow = (this.getPage()-1)*this.getPerPage()+1;
		this.lastRow = this.getPage()*this.getPerPage();
		
	}
	
	//startNum, lastNum 계산하는 메서드
	public void makeNum(Long totalCount) {
		//1. 전체 row의 갯수 구하기
		//2. 전체 page의 갯수 구하기
		Long totalPage = totalCount/this.getPerPage();
		if(totalCount%this.getPerPage()!=0) {
			totalPage++;
		}
		if(this.getPage()>totalPage) {
			this.setPage(totalPage);
		}
		//3. 한 블럭에 출력할 번호의 갯수
		Long perBlock = 5L;
		
		//4. 총 블럭의 수 구하기
		Long totalBlock = totalPage/perBlock;
		if(totalPage%perBlock !=0) {
			totalPage++;
		}
		//5. page 번호로 현재 블럭 번호 구하기
		Long curBlock = this.getPage()/perBlock;
		if(this.getPage()%perBlock !=0) {
			curBlock++;
		}
		//6. page의 시작번호와 끝번호를 계산
		this.startNum = (curBlock-1)*perBlock+1;
		this.lastNum = curBlock*perBlock;
		
	
		if(curBlock==totalBlock) {
			lastNum=totalPage;
			this.after=true;
		}
		
		if(curBlock==1) {
			this.before=true;
		}
		
	}
	
	
	public Long getStartNum() {
		return startNum;
	}

	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}

	public Long getLastNum() {
		return lastNum;
	}

	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}

	public boolean isAfter() {
		return after;
	}

	public void setAfter(boolean after) {
		this.after = after;
	}

	public boolean isBefore() {
		return before;
	}

	public void setBefore(boolean before) {
		this.before = before;
	}


	public Long getPerPage() {
		if(this.perPage==null||this.perPage<1) {
			this.perPage=5L;
		}
		return perPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}

	public Long getPage() {
		if(this.page==null || this.page<1) {
			this.page=1L;
		}
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
