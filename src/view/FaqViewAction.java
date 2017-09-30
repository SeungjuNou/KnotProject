package view;

import com.opensymphony.xwork2.ActionSupport;

import model.FaqVO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;


import java.io.IOException;

public class FaqViewAction extends ActionSupport {
	public static Reader reader;
	public static SqlMapClient sqlMapper;

	private FaqVO paramClass = new FaqVO(); //파라미터를 저장할 객체
	private FaqVO resultClass = new FaqVO(); //쿼리 결과 값을 저장할 객체

	private int currentPage;

	private int faq_no;
	

	// 생성자 먼저 실행.
	public FaqViewAction() throws IOException {

		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml 파일의 설정내용을 가져온다.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml의 내용을 적용한 sqlMapper 객체 생성.
		reader.close();
	}

	// 상세보기
	public String execute() throws Exception { //그다음 execute를 실행

		

		// 해당 번호의 글을 가져온다.
		resultClass = (FaqVO) sqlMapper.queryForObject("selectFaqOne", getFaq_no());// 해당번호의 글을 가져와서 리절트클래스에 담음. 그래서jsp로 갈때 jsp에서 다가져다쓸수있음.

		return SUCCESS; //struts.xml 로 감
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		FaqViewAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		FaqViewAction.sqlMapper = sqlMapper;
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

	


}