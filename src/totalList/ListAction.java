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
	private List list3;
	private List menulist;
	private List menulist2;
	private Map<Integer, Object> list2 = new HashMap<Integer, Object>();
	
	private int currentPage = 1;	//현재 페이지
	private int totalCount; 		// 총 게시물의 수
	private int blockCount;	// 한 페이지의 게시물의 수
	private int blockPage = 5; 	// 한 화면에 보여줄 페이지 수
	private String pagingHtml; 	//페이징을 구현한 HTML
	private PagingAction page; 	// 페이징 클래스
	private String find = ""; // 검색 내용 
	private String userReq = ""; // 사용자가 요청하는 리스트이름.
	private int catLen = 1; //메인 카테고리 길이 
	private String userType="";
	private int mem_lev = 0;
	String mem_id = "";
	
	private int cat_no;
	private int area_cat_no;
	

	public ListAction() throws IOException {
		
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); 
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);	
		reader.close();
	}


	//사용자의 요청을 파악해서 원하는 메서드를 호출하는 메서드
	public String execute() throws Exception {

		//try {
			if (getUserReq().equals("member")) {
				list = complete(memberList());
			} else if(getUserReq().equals("mainCat")) {
				list = complete(mainCatList());
			} else if(getUserReq().equals("areaCat")) {
				list3 = complete(areaCatList());
			}	else if(getUserReq().equals("itemCat")) {
				list = mainCatList();
				list3 = areaCatList();
			} else if (getUserReq().equals("qna")) {
				list = complete(qnaList());
			} else if (getUserReq().equals("faq")) {
				list = complete(faqList());
			} else if (getUserReq().equals("item")) {
				list = complete(itemList());
			} else if (getUserReq().equals("notice")) {
				list = complete(noticeList());
			} else if (getUserReq().equals("order")) {
				list = complete(orderList());
			} else if (getUserReq().equals("main")) {
				mainList();
			}
		//} catch (Exception ex) {
			//return ERROR;
		//}
		

		return SUCCESS;
		
	} //execute 메서드 종료. 


	
	public List memberList() throws Exception { 
		blockCount = 10; //회원목록은 10개씩 띄운다. 
		list = new ArrayList<MemberVO>();
		
		list = sqlMapper.queryForList("selectMemAll");
		
		return list;
	} 
	
	public void menuCatList() throws Exception {
		menulist = new ArrayList<MainCategoryVO>();
		menulist2 = new ArrayList<AreaCategoryVO>();
		
		menulist = sqlMapper.queryForList("selectCatAll");
		menulist2 = sqlMapper.queryForList("selectAreaCatAll");
	}

	public List mainCatList() throws Exception {
		blockCount = 10;
		list = new ArrayList<MainCategoryVO>();

		if (find==null || find.equals("")) {
			list = sqlMapper.queryForList("selectCatAll");
		} else {
			list = sqlMapper.queryForList("CatFindSelectAll", "%"+getFind()+"%"); //검색 했을때.
		}

		return list;
	}

	public List areaCatList() throws Exception {
		blockCount = 10;
		list3 = new ArrayList<AreaCategoryVO>();
		list3 = sqlMapper.queryForList("selectAreaCatAll");
		
		return list3;
	}
	
	public List qnaList() throws Exception { 
		menuCatList();
		blockCount = 5;
		list = new ArrayList<QnaVO>();

		if (find==null || find.equals("")) {
			if (getUserType().equals("admin_nc_")) {
				list = sqlMapper.queryForList("selectNcQnaAll");	
			} else if (getUserType().equals("admin_ok_")) {
				list = sqlMapper.queryForList("selectOkQnaAll");
			} else if (getUserType().equals("admin")) {
				list = sqlMapper.queryForList("selectQnaAll");	
			} else if (getUserType().equals("myPage")) {
				list = sqlMapper.queryForList("selectMyQnaAll", getMem_id());	
			}

		} else {
			list = sqlMapper.queryForList("QnaFindSelectAll", "%"+getFind()+"%"); //검색 했을때.
		}

		return list;
	}
	
	public List faqList() throws Exception { 
		menuCatList();
		blockCount = 10;
		list = new ArrayList<FaqVO>();

		if (find==null || find.equals("")) {
			list = sqlMapper.queryForList("selectFaqAll");
		} else {
			list = sqlMapper.queryForList("FaqFindSelectAll", "%"+getFind()+"%"); //검색 했을때.
		}

		return list;
	}

	public List noticeList() throws Exception {
		menuCatList();
		blockCount = 10;
		list = new ArrayList<NoticeVO>();
		
		if (find==null || find.equals("")) {
			list = sqlMapper.queryForList("selectNoticeAll");
		} else {
			list = sqlMapper.queryForList("NoticeFindSelectAll", "%"+getFind()+"%"); //검색 했을때.
		}

		return list;
	}

	public Map mainList() throws Exception {

		blockCount = 5;
		catLen = (int) sqlMapper.queryForObject("countMainCategory");
		list = new ArrayList<ItemVO>();

		for (int catNo = 1; catNo <= catLen; catNo++) {
			list = sqlMapper.queryForList("selectMainItem", catNo);
			list2.put(catNo, list);
		}

		
		menulist = new ArrayList<MainCategoryVO>();
		menulist2 = new ArrayList<MainCategoryVO>();
		list3 = new ArrayList<MainCategoryVO>();
		
		list3 = sqlMapper.queryForList("selectCatAll");
		
		int listSize = list3.size();
		menulist = list3.subList(0, 5);
		menulist2 = list3.subList(5, listSize);
		
		return list2;
	}

	public List orderList() throws Exception {
		menuCatList();
		blockCount = 10;
		list = new ArrayList<OrderVO>();
		
		if (find==null || find.equals("")) {
			if (getUserType().equals("admin")) {
				list = sqlMapper.queryForList("selectOrderAll");
			} else if (getUserType().equals("myPgae_sal_")) {
				list = sqlMapper.queryForList("selectSalOrderAll", getMem_id());	
			} else if (getUserType().equals("myPage_user_")) {
				list = sqlMapper.queryForList("selectUserOrderAll", getMem_id());	
			}
		} else {
			list = sqlMapper.queryForList("OrderFindSelectAll", "%"+getFind()+"%"); //검색 했을때.
		}

		return list;
	}

	public List itemList() throws Exception {
		menuCatList();
		blockCount = 10; 
		list = new ArrayList<ItemVO>();

		ItemVO itemVo = new ItemVO();
		itemVo.setCat_no(getCat_no());
		itemVo.setArea_cat_no(getArea_cat_no());

		System.out.println(getUserType());
		
		if (find==null || find.equals("")) {
			if (getUserType().equals("admin")) {
				list = sqlMapper.queryForList("selectItemAll");
			} else if (getUserType().equals("admin_nc_")) {
				list = sqlMapper.queryForList("selectNcItemAll");
			} else if (getUserType().equals("admin_ok_")) {
				list = sqlMapper.queryForList("selectOkItemAll");
			} else if (getUserType().equals("myPage")) {
				list = sqlMapper.queryForList("selectMyItemAll", getMem_id());
			} else if (getUserType().equals("other_cat_")) { //메인카테고리 상품리스트 
				list = sqlMapper.queryForList("selectOtherCatItemAll", itemVo);
			} else if (getUserType().equals("other_area_")) { //메인카테고리 상품리스트 
				list = sqlMapper.queryForList("selectOtherAreaCatAll", getArea_cat_no());
			} else if (getUserType().equals("other_area_cat_")) { //지역카테고리 상품리스트 
				list = sqlMapper.queryForList("selectOtherAreaCatItemAll", itemVo);
			}
		
		} else {
			list = sqlMapper.queryForList("itemFindSelectAll", "%"+getFind()+"%"); //검색 했을때.
		}

		return list;
	}


	public List complete(List list) throws Exception {
		
		totalCount = list.size(); 
		page = new PagingAction(currentPage, totalCount, blockCount, blockPage, userType, userReq , getFind());
		
		pagingHtml = page.getPagingHtml().toString(); 
		int lastCount = totalCount;

		if (page.getEndCount() < totalCount) {
			lastCount = page.getEndCount();
		}
		
		list = list.subList(page.getStartCount(), lastCount); 
		
		return list;
	}


	public static Reader getReader() {
		return reader;
	}


	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}


	public List getList() {
		return list;
	}


	public Map<Integer, Object> getList2() {
		return list2;
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


	public int getCatLen() {
		return catLen;
	}


	public static void setReader(Reader reader) {
		ListAction.reader = reader;
	}


	public static void setSqlMapper(SqlMapClient sqlMapper) {
		ListAction.sqlMapper = sqlMapper;
	}


	public void setList(List list) {
		this.list = list;
	}


	public void setList2(Map<Integer, Object> list2) {
		this.list2 = list2;
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


	public void setCatLen(int catLen) {
		this.catLen = catLen;
	}


	public String getUserReq() {
		return userReq;
	}


	public void setUserReq(String userReq) {
		this.userReq = userReq;
	}


	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}
	

	public int getMem_lev() {
		return mem_lev;
	}


	public void setMem_lev(int mem_lev) {
		this.mem_lev = mem_lev;
	}


	public String getMem_id() {
		return mem_id;
	}


	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}


	public List getList3() {
		return list3;
	}


	public void setList3(List list3) {
		this.list3 = list3;
	}


	public int getCat_no() {
		return cat_no;
	}


	public void setCat_no(int cat_no) {
		this.cat_no = cat_no;
	}


	public int getArea_cat_no() {
		return area_cat_no;
	}


	public void setArea_cat_no(int area_cat_no) {
		this.area_cat_no = area_cat_no;
	}


	public List getMenulist() {
		return menulist;
	}


	public void setMenulist(List menulist) {
		this.menulist = menulist;
	}


	public List getMenulist2() {
		return menulist2;
	}


	public void setMenulist2(List menulist2) {
		this.menulist2 = menulist2;
	}

	
	
	
}