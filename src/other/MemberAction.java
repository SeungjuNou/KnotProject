package other;

import com.opensymphony.xwork2.ActionSupport;

import model.*;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;


import java.io.Reader;
import java.sql.SQLException;
import java.util.*;
import java.io.IOException;

public class MemberAction extends ActionSupport {

	public static Reader reader; //파일 스트림을 위한 reader.
	public static SqlMapClient sqlMapper; //SqlMapClient API를 사용하기 위한 sqlMapper 객체.

	private MemberVO paramClass; 
	private MemberVO resultClass; 

	private int mem_no;
	private String mem_id;
	private String mem_pwd;
	private String mem_name;
	private String mem_phone;
	private String mem_img;
	private String memo;
	private int mem_lev;
	private Date mem_date;


	private String userRequest = ""; // 사용자 요청사항.
	Calendar today = Calendar.getInstance(); //회원가입을 위한 Calender 객체 생성.

	
	// 생성자 항상 생성자먼저 실행
	public MemberAction() throws IOException {

		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml 파일의 설정내용을 가져온다. 설정값을 받아옴
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml의 내용을 적용한 sqlMapper 객체 생성.
		reader.close();
	}

	public String form() throws Exception { 
		//회원가입 폼을 띄우는것
		return SUCCESS;
	}

	// 게시판 WRITE 액션
	public String execute() throws Exception { 
		
		//파라미터와 리절트 객체 생성.
		//파라미터를 이용해서 VO 세팅.
		resultClass = new MemberVO();
		System.out.println(getMem_id() + " execute");

		if (userRequest.equals("memberJoin")) {
			memberJoin();
		} else if (userRequest.equals("memberModify")) {
			memberModify();
		} else {
			return ERROR;
		}
		
		return SUCCESS;
	}


	public void memberJoin() throws SQLException {
		memberVoSet();
		System.out.println(paramClass + "객체테스");
		System.out.println(paramClass.getMem_id());
		
		sqlMapper.insert("insertMember", paramClass); 

	}

	public void memberModify() throws SQLException {

		sqlMapper.update("updateMember", paramClass);

	}

	public String memberView() throws Exception {

		resultClass = (MemberVO) sqlMapper.queryForObject("selectMember", getMem_no());
		return SUCCESS;

	}

	public void memberVoSet() {
		
		paramClass = new MemberVO();

		paramClass.setNo(getMem_no());
		paramClass.setMem_id(getMem_id());
		paramClass.setMem_pwd(getMem_pwd());
		paramClass.setMem_name(getMem_name());
		paramClass.setMem_phone(getMem_phone());
		paramClass.setMem_lev(getMem_lev());
		paramClass.setTodate(today.getTime());
		
	}

	public MemberVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(MemberVO paramClass) {
		this.paramClass = paramClass;
	}

	public MemberVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(MemberVO resultClass) {
		this.resultClass = resultClass;
	}

	public int getMem_no() {
		return mem_no;
	}

	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_pwd() {
		return mem_pwd;
	}

	public void setMem_pwd(String mem_pwd) {
		this.mem_pwd = mem_pwd;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_phone() {
		return mem_phone;
	}

	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}

	public String getMem_img() {
		return mem_img;
	}

	public void setMem_img(String mem_img) {
		this.mem_img = mem_img;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public int getMem_lev() {
		return mem_lev;
	}

	public void setMem_lev(int mem_lev) {
		this.mem_lev = mem_lev;
	}

	public Date getMem_date() {
		return mem_date;
	}

	public void setMem_date(Date mem_date) {
		this.mem_date = mem_date;
	}

	public String getUserRequest() {
		return userRequest;
	}

	public void setUserRequest(String userRequest) {
		this.userRequest = userRequest;
	}

	public Calendar getToday() {
		return today;
	}

	public void setToday(Calendar today) {
		this.today = today;
	}

	
	
	
	
}