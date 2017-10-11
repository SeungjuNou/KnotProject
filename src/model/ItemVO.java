package model;

import java.util.Date;

public class ItemVO {
	
	private int no; //
	private String name; //
	private String price;
	private int cat_no;
	private int area_cat_no;
	private String item_sum;
	private String item_detail;
	private String img;
	private int item_readhit; //
	private String sal_id;
	private String sal_name; //
	private String re_date; // 예약할때 입력해줘야 함.
	private int item_check; //작성이나 수정할때 0으로 초기화.
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getCat_no() {
		return cat_no;
	}
	public void setCat_no(int cat_no) {
		this.cat_no = cat_no;
	}
	public int getArea_cat_no() {
		return area_cat_no;
	}
	public void setArea_cat_no(int area_cat_no) {
		this.area_cat_no = area_cat_no;
	}
	public String getItem_sum() {
		return item_sum;
	}
	public void setItem_sum(String item_sum) {
		this.item_sum = item_sum;
	}
	public String getItem_detail() {
		return item_detail;
	}
	public void setItem_detail(String item_detail) {
		this.item_detail = item_detail;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getItem_readhit() {
		return item_readhit;
	}
	public void setItem_readhit(int item_readhit) {
		this.item_readhit = item_readhit;
	}
	public String getSal_id() {
		return sal_id;
	}
	public void setSal_id(String sal_id) {
		this.sal_id = sal_id;
	}
	public String getSal_name() {
		return sal_name;
	}
	public void setSal_name(String sal_name) {
		this.sal_name = sal_name;
	}
	public String getRe_date() {
		return re_date;
	}
	public void setRe_date(String re_date) {
		this.re_date = re_date;
	}
	public int getItem_check() {
		return item_check;
	}
	public void setItem_check(int item_check) {
		this.item_check = item_check;
	}
	

}
