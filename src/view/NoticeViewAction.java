package view;

import com.opensymphony.xwork2.ActionSupport;

import model.NoticeVO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;
import java.io.IOException;

public class NoticeViewAction extends ActionSupport {
	
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	private NoticeVO resultClass = new NoticeVO();
	private int currentPage;
	private int noti_no;

	public NoticeViewAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}

	public String execute() throws Exception {
	
		resultClass = (NoticeVO) sqlMapper.queryForObject("noticeSelectOne", getNoti_no());
		return SUCCESS;

	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		NoticeViewAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		NoticeViewAction.sqlMapper = sqlMapper;
	}

	public NoticeVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(NoticeVO resultClass) {
		this.resultClass = resultClass;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getNoti_no() {
		return noti_no;
	}

	public void setNoti_no(int noti_no) {
		this.noti_no = noti_no;
	}
}