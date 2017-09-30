package view;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

import java.net.URLEncoder;
import model.QnaVO;

public class QnaViewAction extends ActionSupport {
	public static Reader reader;
	public static SqlMapClient sqlMapper;

	private QnaVO paramClass = new QnaVO(); //파라미터를 저장할 객체
	private QnaVO resultClass = new QnaVO(); //쿼리 결과 값을 저장할 객체

	private int currentPage;
	private int qna_no;

/*
	private String fileUploadPath = "./image/";

	private InputStream inputStream;
	private String contentDisposition;
	private long contentLength;*/

	// 생성자
	public QnaViewAction() throws IOException {

		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml 파일의 설정내용을 가져온다.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml의 내용을 적용한 sqlMapper 객체 생성.
		reader.close();
	}

	// 상세보기
	public String execute() throws Exception {

		// 해당 글의 조회수 +1.
		paramClass.setQna_no(getQna_no());

		// 해당 번호의 글을 가져온다.
		resultClass = (QnaVO) sqlMapper.queryForObject("selectQnaOne", getQna_no());

		return SUCCESS;
	}

	/*// 첨부 파일 다운로드
	public String download() throws Exception {

		// 해당 번호의 파일 정보를 가져온다.
		resultClass = (QnaVO) sqlMapper.queryForObject("selectQnaOne", getQna_no());

		// 파일 경로와 파일명을 file 객체에 넣는다.
		File fileInfo = new File(fileUploadPath + resultClass.getQna_img());

		// 다운로드 파일 정보 설정.
		setContentLength(fileInfo.length());
		setContentDisposition("attachment;filename="
				+ URLEncoder.encode(resultClass.getQna_img(), "UTF-8"));
		setInputStream(new FileInputStream(fileUploadPath
				+ resultClass.getQna_img()));

		return SUCCESS;
	}*/

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		QnaViewAction.sqlMapper = sqlMapper;
	}

	public QnaVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(QnaVO paramClass) {
		this.paramClass = paramClass;
	}

	public QnaVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(QnaVO resultClass) {
		this.resultClass = resultClass;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getQna_no() {
		return qna_no;
	}

	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}

	/*public String getFileUploadPath() {
		return fileUploadPath;
	}

	public void setFileUploadPath(String fileUploadPath) {
		this.fileUploadPath = fileUploadPath;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getContentDisposition() {
		return contentDisposition;
	}

	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}

	public long getContentLength() {
		return contentLength;
	}

	public void setContentLength(long contentLength) {
		this.contentLength = contentLength;
	}*/
}
