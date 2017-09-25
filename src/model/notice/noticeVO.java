package model.notice;

import java.util.Date;

public class noticeVO {
	
	private int noti_no;
	private Date noti_date;
	private String noti_subject;
	private String noti_content;
	
	
	public int getNoti_no() {
		return noti_no;
	}
	public void setNoti_no(int noti_no) {
		this.noti_no = noti_no;
	}
	public Date getNoti_date() {
		return noti_date;
	}
	public void setNoti_date(Date noti_date) {
		this.noti_date = noti_date;
	}
	public String getNoti_subject() {
		return noti_subject;
	}
	public void setNoti_subject(String noti_subject) {
		this.noti_subject = noti_subject;
	}
	public String getNoti_content() {
		return noti_content;
	}
	public void setNoti_content(String noti_content) {
		this.noti_content = noti_content;
	}
	
}
