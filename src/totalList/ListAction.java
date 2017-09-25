package totalList;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient; 
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
 
import java.util.*;
import model.member.*;
import totalList.PagingAction;

import java.io.Reader;
import java.io.IOException;


public class ListAction extends ActionSupport {
	
	public static Reader reader;	
	public static SqlMapClient sqlMapper;	

	private List list; //쿼리실행 결과를 담을 list객체 변수 선언.
	
	private int currentPage = 1;	//현재 페이지
	private int totalCount; 		// 총 게시물의 수
	private int blockCount = 5;	// 한 페이지의 게시물의 수
	private int blockPage = 5; 	// 한 화면에 보여줄 페이지 수
	private String pagingHtml; 	//페이징을 구현한 HTML
	private PagingAction page; 	// 페이징 클래스
	private String find = ""; // 검색 내용 
	private String listName = "memberList"; // 사용자가 요청하는 리스트이름.
	

	public ListAction() throws IOException {
		
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); 
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);	
		reader.close();
	}


	//사용자의 요청을 파악해서 원하는 메서드를 호출하는 메서드
	public String execute() throws Exception {

		memberList();

		totalCount = list.size(); 

		page = new PagingAction(currentPage, totalCount, blockCount, blockPage);
		pagingHtml = page.getPagingHtml().toString(); 

		int lastCount = totalCount;

		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount();

		System.out.println(page.getStartCount() + ": getStartCount");
		System.out.println(lastCount + ": lastCount");
		list = list.subList(page.getStartCount(), lastCount); 

		return SUCCESS;
		
	} //execute 메서드 종료. 


	//회원목록 리스트를 불러오는 메서드. 
	public void memberList() throws Exception { 
		list = new ArrayList<memberVO>();
		list = sqlMapper.queryForList("selectMemAll");
	} //memberList 메서드 종료. 

	

	public List getList() {
		return list;
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public int getTotalCount() {
		return totalCount;
	}


	public int getBlockCount() {
		return blockCount;
	}


	public int getBlockPage() {
		return blockPage;
	}


	public String getPagingHtml() {
		return pagingHtml;
	}


	public PagingAction getPage() {
		return page;
	}


	public String getFind() {
		return find;
	}


	public String getListName() {
		return listName;
	}


	public void setList(List list) {
		this.list = list;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


	public void setBlockCount(int blockCount) {
		this.blockCount = blockCount;
	}


	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}


	public void setPagingHtml(String pagingHtml) {
		this.pagingHtml = pagingHtml;
	}


	public void setPage(PagingAction page) {
		this.page = page;
	}


	public void setFind(String find) {
		this.find = find;
	}


	public void setListName(String listName) {
		this.listName = listName;
	}


	public static Reader getReader() {
		return reader;
	}


	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}


	public static void setReader(Reader reader) {
		ListAction.reader = reader;
	}


	public static void setSqlMapper(SqlMapClient sqlMapper) {
		ListAction.sqlMapper = sqlMapper;
	}
	
	
	
	
	
	
}