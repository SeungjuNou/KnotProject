package other;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheck extends AbstractInterceptor 
		implements SessionAware, ServletResponseAware, ServletRequestAware, RequestAware  {

	HttpServletResponse response;
	Map sessionMap;
	Map requestMap;
	HttpServletRequest request;
	String result;
	ActionContext context = ActionContext.getContext();
	Map<String, Object> session = (Map<String, Object>)context.getSession();
	int mem_id = 0;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		if (session.get("mem_lev") != null) {
			mem_id = ((Integer)(session.get("mem_lev"))).intValue();

			if ( mem_id = 0 ) {
   				result = "nonUser"; //비 로그인 유저.
	   		} else {
	   			result = invocation.invoke(); //로그인 유저.
	   		} 

		} else {
			
			result = "nonUser";
		}

		return result;  
	}

	@Override
	public void init() {
	}

	@Override
	public void destroy() {
	}

	public void setSession(Map session) {
		this.sessionMap = session;
	}	
	//RequestAware의 setRequest 구현
	public void setRequest(Map requestMap) {
		this.requestMap = requestMap;
	}	
	//ServletRequestAware의 serServletRequest 구현
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}	

	
	

}