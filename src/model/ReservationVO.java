package model.reservation;

import java.util.Date;

public class ReservationVO {
	
	private int re_item_no;
	private String re_item;
	private String re_mem_id;
	private String re_sal_id;
	private int re_price;
	private String re_cat_no;
	private Date order_date;
	private String order_dtl;
	
	
	public int getRe_item_no() {
		return re_item_no;
	}
	public void setRe_item_no(int re_item_no) {
		this.re_item_no = re_item_no;
	}
	public String getRe_item() {
		return re_item;
	}
	public void setRe_item(String re_item) {
		this.re_item = re_item;
	}
	public String getRe_mem_id() {
		return re_mem_id;
	}
	public void setRe_mem_id(String re_mem_id) {
		this.re_mem_id = re_mem_id;
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

	
	
}
