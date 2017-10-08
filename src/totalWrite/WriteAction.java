package totalWrite;

import com.opensymphony.xwork2.ActionSupport;

import model.*;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;

import java.util.*;

import org.apache.commons.io.FileUtils;

import java.io.Reader;
import java.sql.SQLException;
import java.io.File;
import java.io.IOException;


public class WriteAction extends ActionSupport implements  ServletRequestAware {

	public static Reader reader; 
	public static SqlMapClient sqlMapper; 
	
	private int currentPage; 
	HttpServletRequest request;
	Calendar today = Calendar.getInstance(); 
	
	private File upload;
	private String uploadContentType; 
	private String uploadFileName; 
	private String fileUploadPath;
	
	private String userReq;
	private String modifyReq="";

	private int no = 0;
	private String name;
	private String content;
	private Date todate;
	private String answer;
	private int answer_check;
	private String cat_code;
	
	private String mem_id;
	private String mem_pwd;
	private String mem_name;
	private String mem_phone;
	private String memo;
	private int mem_lev;


	private String img = "";

	
	public WriteAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}


	public String form() throws Exception {
		return SUCCESS;
	}


	@SuppressWarnings("deprecation")
	public String execute() throws Exception {
		todate = today.getTime();
		fileUploadPath = request.getRealPath("/image/"+ getUserReq() + "/");

		if (getUserReq().equals("mainCatWrite")) {
			mainCatWrite();
		} else if (getUserReq().equals("faqWrite")) {
			faqWrite();
		}
		
		return SUCCESS;
	
	}
	
	public void mainCatWrite() throws SQLException, IOException {

		MainCategoryVO paramClass = new MainCategoryVO();

		
		//file upload start
		if (getUpload() != null) {
			if(no == 0 ) {
				no = (int) sqlMapper.queryForObject("mainCatSeqNo");
			} else {
				no = getNo();
			}
			img = uploadImg();
		}
		paramClass.setImg(img);
		//file upload end
		
		paramClass.setNo(getNo());
		paramClass.setName(getName());

		System.out.println("진입점 테스트 입니다.");
		System.out.println(paramClass.getNo());
		System.out.println(paramClass.getName());
		
		if (getModifyReq().equals("") || getModifyReq() == null ) {
			sqlMapper.insert("mainCatInsertBoard", paramClass);

		} else {
			sqlMapper.update("mainCatModifyBoard", paramClass);
		}


	}


	public void faqWrite() throws SQLException, IOException {

		FaqVO paramClass = new FaqVO();
		
		paramClass.setNo(getNo());
		paramClass.setName(getName());
		paramClass.setContent(getContent());
		
		if (getModifyReq().equals("") || getModifyReq() == null ) {
			sqlMapper.insert("insertFaqBoard", paramClass);
		} else {
			sqlMapper.update("mainfaqModifyBoard", paramClass);
		}
	}


	public String uploadImg() throws IOException {
	
		String file_name = userReq + no;
		String file_ext = getUploadFileName().substring(getUploadFileName().lastIndexOf('.') + 1, getUploadFileName().length());
		
		File destFile = new File(fileUploadPath + file_name + "." + file_ext);
		
		FileUtils.copyFile(getUpload(), destFile);


		String resultName = file_name + "." + file_ext;
		return resultName;
		
	}

	


	public static Reader getReader() {
		return reader;
	}


	public static void setReader(Reader reader) {
		WriteAction.reader = reader;
	}


	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}


	public static void setSqlMapper(SqlMapClient sqlMapper) { 
		WriteAction.sqlMapper = sqlMapper;
	}


	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
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

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getUserReq() {
		return userReq;
	}

	public void setUserReq(String userReq) {
		this.userReq = userReq;
	}


	public Calendar getToday() {
		return today;
	}


	public void setToday(Calendar today) {
		this.today = today;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Date getTodate() {
		return todate;
	}


	public void setTodate(Date todate) {
		this.todate = todate;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public int getAnswer_check() {
		return answer_check;
	}


	public void setAnswer_check(int answer_check) {
		this.answer_check = answer_check;
	}


	public String getCat_code() {
		return cat_code;
	}


	public void setCat_code(String cat_code) {
		this.cat_code = cat_code;
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


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public String getModifyReq() {
		return modifyReq;
	}


	public void setModifyReq(String modifyReq) {
		this.modifyReq = modifyReq;
	}


	
	
	
	
	

}