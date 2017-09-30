package write;

import com.opensymphony.xwork2.ActionSupport;

import model.MainCategoryVO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;

import org.apache.commons.io.FileUtils;

import java.io.Reader;
import java.io.File;
import java.io.IOException;


public class MainCatWriteAction extends ActionSupport {

	public static Reader reader; 
	public static SqlMapClient sqlMapper; 

	private MainCategoryVO paramClass; 
	private MainCategoryVO resultClass;
	
	private int currentPage; 

	private int cat_no;
	private String cat_name;
	private String cat_img;

	private File upload; 
	private String uploadContentType; 
	private String uploadFileName; 
	private String fileUploadPath = "./image/categoryImg/";
	
	public MainCatWriteAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}

	public String form() throws Exception {
		return SUCCESS;
	}

	public String execute() throws Exception {

		paramClass = new MainCategoryVO();
		resultClass = new MainCategoryVO();

		paramClass.setCat_name(getCat_name());

		sqlMapper.insert("mainCatInsertBoard", paramClass);
		
		System.out.println(getUpload());
		if (getUpload() != null) {
			System.out.println("uploadcheck");
			resultClass = (MainCategoryVO) sqlMapper.queryForObject("mainCatSelectLastNo");

			String file_name = "categoryfile_" + resultClass.getCat_no();
			String file_ext = getUploadFileName().substring(getUploadFileName().lastIndexOf('.') + 1, getUploadFileName().length());

			File destFile = new File(fileUploadPath + file_name + "." + file_ext);
			FileUtils.copyFile(getUpload(), destFile);
			paramClass.setCat_no(resultClass.getCat_no());
			paramClass.setCat_img(file_name + "." + file_ext);

			sqlMapper.update("mainCatUpdateFile", paramClass);
		}
		
		return SUCCESS;
		
	
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		MainCatWriteAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		MainCatWriteAction.sqlMapper = sqlMapper;
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

	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}

	public String getCat_img() {
		return cat_img;
	}

	public void setCat_img(String cat_img) {
		this.cat_img = cat_img;
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