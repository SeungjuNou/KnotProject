package view;

import com.opensymphony.xwork2.ActionSupport;

import model.MainCategoryVO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;
import java.net.URLEncoder;
import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainCatViewAction extends ActionSupport {
	public static Reader reader;
	public static SqlMapClient sqlMapper;

	private MainCategoryVO paramClass = new MainCategoryVO();
	private MainCategoryVO resultClass = new MainCategoryVO();  

	private int currentPage;

	private int cat_no;
	
	private String fileUploadPath = "./image/categoryImg/";
	private InputStream inputStream;
	private String contentDisposition;
	private long contentLength;

	public MainCatViewAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); 	//sqlMapConfig.xml으로 실행시킴  그곳에서 joinSQL을 실행시킬수있다
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); 
		reader.close();
	}

public String execute() throws Exception {

		
		paramClass.setCat_no(getCat_no());
		resultClass = (MainCategoryVO) sqlMapper.queryForObject("mainCatSelectOne", getCat_no());
		return SUCCESS;
	}

	public String download() throws Exception {

		resultClass = (MainCategoryVO) sqlMapper.queryForObject("mainCatSelectOne", getCat_no());
		File fileInfo = new File(fileUploadPath + resultClass.getCat_img());
		setContentLength(fileInfo.length());
		setContentDisposition("attachment;filename=" + URLEncoder.encode(resultClass.getCat_img(), "UTF-8"));
		setInputStream(new FileInputStream(fileUploadPath + resultClass.getCat_img()));

		return SUCCESS;
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		MainCatViewAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		MainCatViewAction.sqlMapper = sqlMapper;
	}

	public MainCategoryVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(MainCategoryVO paramClass) {
		this.paramClass = paramClass;
	}

	public MainCategoryVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(MainCategoryVO resultClass) {
		this.resultClass = resultClass;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getCat_no() {
		return cat_no;
	}

	public void setCat_no(int cat_no) {
		this.cat_no = cat_no;
	}

	public String getFileUploadPath() {
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
	}

}