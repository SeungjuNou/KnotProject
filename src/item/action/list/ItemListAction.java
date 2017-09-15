package item.action.list;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient; 
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
 
import java.util.*;
import java.io.Reader;
import java.io.IOException;

public class ItemListAction extends ActionSupport {
	
	public static Reader reader;	
	public static SqlMapClient sqlMapper;	
	

	public ItemListAction() throws IOException {
		
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); 
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);	
		reader.close();
	}

	
	public String execute() throws Exception {

		return SUCCESS;
	}
	
	
}