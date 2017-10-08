package totalView;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import model.*;

import java.io.Reader;
import java.io.IOException;

import java.sql.SQLException;

public class ViewAction extends ActionSupport {
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	  
	private int currentPage;
	private int no;
	private String userReq;
	
	Object resultClass;


	 
	public ViewAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); 
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); 
		reader.close();
	}



	public String execute() throws Exception {

		if (getUserReq().equals("faqView")) {
			faqView();
		} else if (getUserReq().equals("adminMainCatView")) {
			adminMainCatView();
		}

		return SUCCESS;
	}





	public void faqView() throws SQLException {

		resultClass = new FaqVO();
		resultClass = (FaqVO) sqlMapper.queryForObject("selectFaqOne", getNo());
	}

	public void adminMainCatView() throws SQLException {

		resultClass = new MainCategoryVO();
		resultClass = (MainCategoryVO) sqlMapper.queryForObject("mainCatSelectOne", getNo());
	}





	public static Reader getReader() {
		return reader;
	}



	public static void setReader(Reader reader) {
		ViewAction.reader = reader;
	}



	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}



	public static void setSqlMapper(SqlMapClient sqlMapper) {
		ViewAction.sqlMapper = sqlMapper;
	}



	public int getCurrentPage() {
		return currentPage;
	}



	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}



	public int getNo() {
		return no;
	}



	public void setNo(int no) {
		this.no = no;
	}



	public String getUserReq() {
		return userReq;
	}



	public void setUserReq(String userReq) {
		this.userReq = userReq;
	}



	public Object getResultClass() {
		return resultClass;
	}



	public void setResultClass(Object resultClass) {
		this.resultClass = resultClass;
	}


	

	
}