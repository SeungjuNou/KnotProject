package modify;

import com.opensymphony.xwork2.ActionSupport;

import model.MainCategoryVO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class MainCatModifyAction extends ActionSupport {
	public static Reader reader;
	public static SqlMapClient sqlMapper;

	private MainCategoryVO paramClass; 
	private MainCategoryVO resultClass; 

	private int currentPage;	
	
	private int cat_no;
	private String cat_name;
	private String old_file;

	private File upload; 
	private String uploadContentType; 
	private String uploadFileName; 
	private String fileUploadPath = "./image/categoryImg/";

	public MainCatModifyAction() throws IOException {
		
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); 
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); 
		reader.close();
	}

	public String execute() throws Exception {
		
		paramClass = new MainCategoryVO();
		resultClass = new MainCategoryVO();

		paramClass.setCat_no(getCat_no());
		paramClass.setCat_name(getCat_name());
		

		sqlMapper.update("mainCatUpdateBoard", paramClass);

		if (getUpload() != null) {
			
			String file_name = "categoryfile_" + getCat_no();
		           String file_ext = getUploadFileName().substring(getUploadFileName().lastIndexOf('.')+1,getUploadFileName().length());
			
			File deleteFile = new File(fileUploadPath + getOld_file());
			deleteFile.delete();
			
			File destFile = new File(fileUploadPath + file_name + "." + file_ext);
			FileUtils.copyFile(getUpload(), destFile);
			
			paramClass.setCat_img(getUploadFileName());
			paramClass.setCat_img(file_name + "." + file_ext);
		
			sqlMapper.update("mainCatUpdateFile", paramClass);
		}

		resultClass = (MainCategoryVO) sqlMapper.queryForObject("mainCatSelectOne", getCat_no());

		return SUCCESS;
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		MainCatModifyAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		MainCatModifyAction.sqlMapper = sqlMapper;
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

	public String getOld_file() {
		return old_file;
	}

	public void setOld_file(String old_file) {
		this.old_file = old_file;
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