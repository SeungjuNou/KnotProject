package model;

import java.util.Date;

public class QnaVO {
	
	private int no;
	private String mem_id;
	private String mem_name;
	private String name;
	private String content;
	private String answer;
	private Date todate;
	private String img;
	private int answer_check;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Date getTodate() {
		return todate;
	}
	public void setTodate(Date todate) {
		this.todate = todate;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getAnswer_check() {
		return answer_check;
	}
	public void setAnswer_check(int answer_check) {
		this.answer_check = answer_check;
	}
	
	
	

}
