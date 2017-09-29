package write;

import com.opensymphony.xwork2.ActionSupport;

import model.NoticeVO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;
import java.io.Reader;
import java.io.IOException;


public class NoticeWriteAction extends ActionSupport {

	public static Reader reader; 
	public static SqlMapClient sqlMapper; 

	private NoticeVO paramClass; 
	private NoticeVO resultClass;

	private int currentPage; 

	private int noti_no;
	private Date noti_date;
	private String noti_subject;
	private String noti_content;
	Calendar today = Calendar.getInstance();
	
	public NoticeWriteAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}

	public String form() throws Exception {
		return SUCCESS;
	}

	public String execute() throws Exception {

		paramClass = new NoticeVO();

		paramClass.setNoti_no(getNoti_no());
		paramClass.setNoti_subject(getNoti_subject());
		paramClass.setNoti_content(getNoti_content());
		paramClass.setNoti_date(today.getTime());  //캘린더 객체에 getTime()을 호출해서 날짜를 입력한다. 

		sqlMapper.insert("noticeInsertBoard", paramClass);
System.out.println("NoticeWriteAction");
		return SUCCESS;
	}

	public NoticeVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(NoticeVO resultClass) {
		this.resultClass = resultClass;
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		NoticeWriteAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		NoticeWriteAction.sqlMapper = sqlMapper;
	}

	public NoticeVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(NoticeVO paramClass) {
		this.paramClass = paramClass;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

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

	public Calendar getToday() {
		return today;
	}

	public void setToday(Calendar today) {
		this.today = today;
	}

	}