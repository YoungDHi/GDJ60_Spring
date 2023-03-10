package com.iu.s1.bankBook;

public class BankBookDTO {
	private Long bookNumber;
	private String bookName;
	private Double bookRate;
	private Integer bookSale;
	private String bookDetail;
	
	public Long getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(Long bookNumber) {
		this.bookNumber = bookNumber;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Double getBookRate() {
		return bookRate;
	}
	public void setBookRate(Double bookRate) {
		this.bookRate = bookRate;
	}
	public Integer getBookSale() {
		if(this.bookSale == null || this.bookSale != 1) {
			bookSale = 0;
		}
		return bookSale;
	}
	public void setBookSale(Integer bookSale) {
		if(bookSale == null || bookSale != 1) {
			bookSale=0;
		}
		this.bookSale = bookSale;
	}
	public String getBookDetail() {
		return bookDetail;
	}
	public void setBookDetail(String bookDetail) {
		this.bookDetail = bookDetail;
	}
	
	
}
