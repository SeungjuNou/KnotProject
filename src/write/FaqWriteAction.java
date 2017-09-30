package write;

import com.opensymphony.xwork2.ActionSupport;

import model.FaqVO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;


import java.io.Reader;
import java.io.IOException;



public class FaqWriteAction extends ActionSupport {

	public static Reader reader; //파일 스트림을 위한 reader.
	public static SqlMapClient sqlMapper; //SqlMapClient API를 사용하기 위한 sqlMapper 객체.

	private FaqVO paramClass; //파라미터를 저장할 객체
	private FaqVO resultClass; //쿼리 결과 값을 저장할 객체

	private int currentPage; //현재 페이지

	private int faq_no; //글번호
	private String faq_subject; //제목
	private String faq_content; //내용

	
	// 생성자 항상 생성자먼저 실행
	public FaqWriteAction() throws IOException {

		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml 파일의 설정내용을 가져온다. 설정값을 받아옴
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml의 내용을 적용한 sqlMapper 객체 생성.
		reader.close();
	}

	public String form() throws Exception { 
		//등록 폼을 띄우는것
		return SUCCESS;
	}

	// 게시판 WRITE 액션
	public String execute() throws Exception { 
		
		//파라미터와 리절트 객체 생성.
		paramClass = new FaqVO();
		resultClass = new FaqVO();
		
		// 등록할 항목 설정.
		paramClass.setFaq_no(getFaq_no());  
		paramClass.setFaq_subject(getFaq_subject());
		paramClass.setFaq_content(getFaq_content());
		
		System.out.println("test");
		// 등록 쿼리 수행.
		sqlMapper.insert("insertFaqBoard", paramClass); 
		
		System.out.println("test22");
		
		return SUCCESS;
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		FaqWriteAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		FaqWriteAction.sqlMapper = sqlMapper;
	}

	public FaqVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(FaqVO paramClass) {
		this.paramClass = paramClass;
	}

	public FaqVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(FaqVO resultClass) {
		this.resultClass = resultClass;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getFaq_no() {
		return faq_no;
	}

	public void setFaq_no(int faq_no) {
		this.faq_no = faq_no;
	}

	public String getFaq_subject() {
		return faq_subject;
	}

	public void setFaq_subject(String faq_subject) {
		this.faq_subject = faq_subject;
	}

	public String getFaq_content() {
		return faq_content;
	}

	public void setFaq_content(String faq_content) {
		this.faq_content = faq_content;
	}

	
}