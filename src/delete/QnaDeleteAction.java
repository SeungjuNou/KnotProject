package delete;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.File;
import java.io.Reader;
import java.io.IOException;
import model.QnaVO;

public class QnaDeleteAction extends ActionSupport {
	public static Reader reader;
	public static SqlMapClient sqlMapper;

	private QnaVO paramClass; //파라미터를 저장할 객체
	private QnaVO resultClass; //쿼리 결과 값을 저장할 객체

	private int currentPage;	//현재 페이지
	
	private String fileUploadPath = "./image/";
	
	private int qna_no;
	
	
	// 생성자
	public QnaDeleteAction() throws IOException {
		
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml 파일의 설정내용을 가져온다.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml의 내용을 적용한 sqlMapper 객체 생성.
		reader.close();
	}

	// 게시글 글 삭제
	public String execute() throws Exception {
		
		//파라미터와 리절트 객체 생성.
		paramClass = new QnaVO();
		resultClass = new QnaVO();
		
		// 해당 번호의 글을 가져온다.
		resultClass = (QnaVO) sqlMapper.queryForObject("selectQnaOne", getQna_no());

		//서버 파일 삭제
		File deleteFile = new File(fileUploadPath + resultClass.getQna_no());
		deleteFile.delete();

		// 삭제할 항목 설정.
		paramClass.setQna_no(getQna_no());
				
		// 삭제 쿼리 수행.
		sqlMapper.update("qnadeleteBoard", paramClass);

		return SUCCESS;
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		QnaDeleteAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		QnaDeleteAction.sqlMapper = sqlMapper;
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

	public String getFileUploadPath() {
		return fileUploadPath;
	}

	public void setFileUploadPath(String fileUploadPath) {
		this.fileUploadPath = fileUploadPath;
	}

	public int getQna_no() {
		return qna_no;
	}

	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}
}
	
	