package write;

import com.opensymphony.xwork2.ActionSupport;

import model.QnaVO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;
import java.io.Reader;
import java.io.IOException;

import java.io.File;
import org.apache.commons.io.FileUtils;

public class QnaWriteAction extends ActionSupport {

	public static Reader reader; //파일 스트림을 위한 reader.
	public static SqlMapClient sqlMapper; //SqlMapClient API를 사용하기 위한 sqlMapper 객체.

	private QnaVO paramClass; //파라미터를 저장할 객체
	private QnaVO resultClass; //쿼리 결과 값을 저장할 객체

	private int currentPage; //현재 페이지

	private int qna_no;
	private String qna_mem_id;
	private String qna_name;
	private String qna_subject;
	private String qna_content;
	private String qna_answer;
	private Date qna_date;
	private String qna_img;
	private int qna_check;
	Calendar today = Calendar.getInstance(); //오늘 날짜 구하기.

	private File upload; //파일 객체
	private String uploadContentType; //컨텐츠 타입
	private String uploadFileName; //파일 이름
	private String fileUploadPath = "./image/"; //업로드 경로.

	// 생성자
	public QnaWriteAction() throws IOException {

		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml 파일의 설정내용을 가져온다.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml의 내용을 적용한 sqlMapper 객체 생성.
		reader.close();
	}

	public String form() throws Exception {
		//등록 폼.
		return SUCCESS;
	}

	// 게시판 WRITE 액션
	public String execute() throws Exception {

		//파라미터와 리절트 객체 생성.
		paramClass = new QnaVO();
		resultClass = new QnaVO();

		// 등록할 항목 설정.
		paramClass.setQna_mem_id(getQna_mem_id());
		paramClass.setQna_name(getQna_name());
		paramClass.setQna_subject(getQna_subject());
		paramClass.setQna_content(getQna_content());
		paramClass.setQna_answer(getQna_answer());
		paramClass.setQna_date(today.getTime());
		paramClass.setQna_check(0);
		System.out.println("qq");
		// 등록 쿼리 수행.
		sqlMapper.insert("qnaInsert", paramClass);
		System.out.println("qqss");
		//ASDF
		// 첨부파일을 선택했다면 파일을 업로드한다.
		if (getUpload() != null) {   

			//등록한 글 번호 가져오기.
			resultClass = (QnaVO) sqlMapper.queryForObject("selectQnaLastNo");

			//실제 서버에 저장될 파일 이름과 확장자 설정.
			String file_name = "file_" + resultClass.getQna_no();
			String file_ext = getUploadFileName().substring(
					getUploadFileName().lastIndexOf('.') + 1,
					getUploadFileName().length());

			//서버에 파일 저장.
			File destFile = new File(fileUploadPath + file_name + "."
					+ file_ext);
			FileUtils.copyFile(getUpload(), destFile);

			//파일 정보 파라미터 설정.
			paramClass.setQna_no(resultClass.getQna_no());
			paramClass.setQna_img(file_name + "." + file_ext);	//서버에 저장한 파일 이름

			//파일 정보 업데이트.
			sqlMapper.update("qnaupdateFile", paramClass);
		}

		return SUCCESS;
		
		
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		QnaWriteAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		QnaWriteAction.sqlMapper = sqlMapper;
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

	public String getQna_mem_id() {
		return qna_mem_id;
	}

	public void setQna_mem_id(String qna_mem_id) {
		this.qna_mem_id = qna_mem_id;
	}

	public String getQna_name() {
		return qna_name;
	}

	public void setQna_name(String qna_name) {
		this.qna_name = qna_name;
	}

	public String getQna_subject() {
		return qna_subject;
	}

	public void setQna_subject(String qna_subject) {
		this.qna_subject = qna_subject;
	}

	public String getQna_content() {
		return qna_content;
	}

	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}

	public String getQna_answer() {
		return qna_answer;
	}

	public void setQna_answer(String qna_answer) {
		this.qna_answer = qna_answer;
	}

	public Date getQna_date() {
		return qna_date;
	}

	public void setQna_date(Date qna_date) {
		this.qna_date = qna_date;
	}

	public String getQna_img() {
		return qna_img;
	}

	public void setQna_img(String qna_img) {
		this.qna_img = qna_img;
	}

	public int getQna_check() {
		return qna_check;
	}

	public void setQna_check(int qna_check) {
		this.qna_check = qna_check;
	}

	public Calendar getToday() {
		return today;
	}

	public void setToday(Calendar today) {
		this.today = today;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getFileUploadPath() {
		return fileUploadPath;
	}

	public void setFileUploadPath(String fileUploadPath) {
		this.fileUploadPath = fileUploadPath;
	}
}