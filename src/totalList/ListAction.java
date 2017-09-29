package totalList;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient; 
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
 
import java.util.*;
import model.*;
import totalList.PagingAction;

import java.io.Reader;
import java.io.IOException;


public class ListAction extends ActionSupport {
	
	public static Reader reader;	
	public static SqlMapClient sqlMapper;	

	private List list; //쿼리실행 결과를 담을 list객체 변수 선언.
	
	private int currentPage = 1;	//현재 페이지
	private int totalCount; 		// 총 게시물의 수
	private int blockCount;	// 한 페이지의 게시물의 수
	private int blockPage = 5; 	// 한 화면에 보여줄 페이지 수
	private String pagingHtml; 	//페이징을 구현한 HTML
	private PagingAction page; 	// 페이징 클래스
	private String find = ""; // 검색 내용 
	private String listName = ""; // 사용자가 요청하는 리스트이름.
	

	public ListAction() throws IOException {
		
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); 
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);	
		reader.close();
	}


	//사용자의 요청을 파악해서 원하는 메서드를 호출하는 메서드
	public String execute() throws Exception {

		System.out.println(getListName());
		if (getListName().equals("memberList")) {
			complete(memberList());
		} else if (getListName().equals("qnaList")) {
			complete(qnaList());
		} else if (getListName().equals("faqList")) {
			complete(faqList());
		} else if (getListName().equals("itemList")) {
			complete(itemList());
		} else if (getListName().equals("noticeList")) {
			complete(noticeList());
		} else {
			complete(memberList());
		}

		return SUCCESS;
		
	} //execute 메서드 종료. 


	//회원목록 리스트를 불러오는 메서드. 
	public List memberList() throws Exception { 
		blockCount = 10; //회원목록은 10개씩 띄운다. 
		list = new ArrayList<MemberVO>();
		list = sqlMapper.queryForList("selectMemAll");
		return list;
	} //memberList 메서드 종료. 
	
//Q&A 게시글을 불러오는 메서드
	public List qnaList() throws Exception { 
		blockCount = 10;
		list = new ArrayList<QnaVO>();
		list = sqlMapper.queryForList("selectQnaAll");
		return list;
	}
	
	public List faqList() throws Exception { 
		return list;
	}
	//상품리스트를 불러오는 메서드
	public List itemList() throws Exception { 
		list = new ArrayList<ItemVO>();
		list = sqlMapper.queryForList("selectItemAll");
		return list;
	}

	public List noticeList() throws Exception {
		list = new ArrayList<NoticeVO>();
		list = sqlMapper.queryForList("selectNoticeAll");
		return list;
	}

	public List mainList() throws Exception { 
		return list;
	}


	public void complete(List list) throws Exception {
		totalCount = list.size(); 
		System.out.println(blockCount);
		page = new PagingAction(currentPage, totalCount, blockCount, blockPage);
		pagingHtml = page.getPagingHtml().toString(); 

		int lastCount = totalCount;

		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount();

		list = list.subList(page.getStartCount(), lastCount); 
	}



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