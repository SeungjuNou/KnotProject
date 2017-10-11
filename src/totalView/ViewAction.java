package totalView;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import model.*;
import auth.*;

import java.io.Reader;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

public class ViewAction extends ActionSupport implements ServletRequestAware {
	
	HttpServletRequest request;
	HttpSession session;
	
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	  
	private int currentPage;
	private int no;
	private String mem_id;
	private String userReq;
	private String result = SUCCESS;
	
	Object resultClass;
	LoginAction loginAction = new LoginAction();


	 
	public ViewAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); 
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); 
		reader.close();
	}



	public String execute() throws Exception {
		
		if (getUserReq().equals("faq")) {
			faqView();
		} else if (getUserReq().equals("mainCat")) {
			mainCatView();
		} else if (getUserReq().equals("member")) {
			result = memberView();
		} else if (getUserReq().equals("qna")) {
			result = qnaView();
		} else if (getUserReq().equals("notice")) {
			noticeView();
		} else if (getUserReq().equals("order")) {
			result = orderView();	
		} else if (getUserReq().equals("item")) {
			itemView();
		} else {
			result = ERROR;
		}

		return result;
	}


	public void faqView() throws SQLException {

		resultClass = new FaqVO();
		resultClass = (FaqVO) sqlMapper.queryForObject("selectFaqOne", getNo());
	}

	public void mainCatView() throws SQLException {

		resultClass = new MainCategoryVO();
		resultClass = (MainCategoryVO) sqlMapper.queryForObject("mainCatSelectOne", getNo());
	}

	public String memberView() throws SQLException {

		resultClass = new MemberVO();
		resultClass = (MemberVO) sqlMapper.queryForObject("selectMemberOne", getMem_id());

		String mem_id = (String) request.getSession().getAttribute("mem_id").toString();
		String dbMem_id = (String) ((MemberVO) resultClass).getMem_id();
		
		if (loginAction.userAuth(dbMem_id, mem_id)) {
			result = SUCCESS;
		} else {
			result = ERROR;
		}
		
		return result;

	}

	public String qnaView() throws SQLException {

		resultClass = new QnaVO();
		resultClass = (QnaVO) sqlMapper.queryForObject("selectQnaOne", getNo());

		String mem_id = (String) request.getSession().getAttribute("mem_id").toString();
		String dbMem_id = (String) ((QnaVO) resultClass).getMem_id();
		
		if (loginAction.userAuth(dbMem_id, mem_id)) {
			result = SUCCESS;
		} else {
			result = ERROR;
		}
		
		return result;
	}

	public String orderView() throws SQLException {

		resultClass = new OrderVO();
		resultClass = (OrderVO) sqlMapper.queryForObject("selectOrderOne", getNo());

		String mem_id = (String) request.getSession().getAttribute("mem_id").toString();
		String dbMem_id = "admin"; //오더에 MEM_ID 랑 이름 두개가 존재해야함. 
				//(String) ((OrderVO) resultClass).getMem_id();
		
		if (loginAction.userAuth(dbMem_id, mem_id)) {
			result = SUCCESS;
		} else {
			result = ERROR;
		}
		
		return result;
	}

	public void itemView() throws SQLException {

		resultClass = new ItemVO();
		resultClass = (ItemVO) sqlMapper.queryForObject("selectItemOne", getNo());

		String mem_id = (String) request.getSession().getAttribute("mem_id").toString();
		String dbMem_id = (String) ((ItemVO) resultClass).getSal_id();
		
		if (loginAction.userAuth(dbMem_id, mem_id)) {
			result = SUCCESS;
		} else {
			result = ERROR;
		}
		
	}

	public void noticeView() throws SQLException {

		resultClass = new NoticeVO();
		resultClass = (NoticeVO) sqlMapper.queryForObject("noticeSelectOne", getNo());
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


	public String getMem_id() {
		return mem_id;
	}



	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
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


	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}


	
}