package model;

import java.util.Date;

public class OrderVO {
	
	private int no; //예약번호.
	private String re_item; //상품 이름.
	private String re_mem_name; //예약자 이름.
	private String re_sal_id;  //판매자 id.
	private int re_price;	  //상품 가격.
	private String checkin_date; // 체크인 날짜.
	private String checkout_date; // 체크아웃 날짜.
	private String re_cat_no; //상품 카테고리 번호.
	private Date order_date; // 기 예약 일자.
	private String order_dtl; //주문 요청사항.
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getRe_item() {
		return re_item;
	}
	public void setRe_item(String re_item) {
		this.re_item = re_item;
	}
	public String getRe_mem_name() {
		return re_mem_name;
	}
	public void setRe_mem_name(String re_mem_name) {
		this.re_mem_name = re_mem_name;
	}
	public String getRe_sal_id() {
		return re_sal_id;
	}
	public void setRe_sal_id(String re_sal_id) {
		this.re_sal_id = re_sal_id;
	}
	public int getRe_price() {
		return re_price;
	}
	public void setRe_price(int re_price) {
		this.re_price = re_price;
	}
	public String getRe_cat_no() {
		return re_cat_no;
	}
	public void setRe_cat_no(String re_cat_no) {
		this.re_cat_no = re_cat_no;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public String getOrder_dtl() {
		return order_dtl;
	}
	public void setOrder_dtl(String order_dtl) {
		this.order_dtl = order_dtl;
	}
	public String getCheckin_date() {
		return checkin_date;
	}
	public void setCheckin_date(String checkin_date) {
		this.checkin_date = checkin_date;
	}
	public String getCheckout_date() {
		return checkout_date;
	}
	public void setCheckout_date(String checkout_date) {
		this.checkout_date = checkout_date;
	}

	
	
}
