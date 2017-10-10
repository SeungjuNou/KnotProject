package intercept;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheck extends AbstractInterceptor implements ServletRequestAware {

	String result;
	
	HttpServletRequest request;
	HttpSession session;

	int mem_lev = 0;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		session = ServletActionContext.getRequest().getSession(false);
		
		try{
			mem_lev = ((Integer)(session.getAttribute("mem_lev"))).intValue();
			
			if ( mem_lev >= 1) { //lev가 1 이상이면.
	   			result = invocation.invoke();
	   		} else {
	   			result = "login";
	   		}
			
		} catch (Exception ex) {
			result = "login";
		}
		
		return result;  
	}


	@Override
	public void init() {
	}

	@Override
	public void destroy() {
	}

	
	public HttpServletRequest getRequest() {
		return request;
	}


	public HttpSession getSession() {
		return session;
	}


	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}


	public void setSession(HttpSession session) {
		this.session = session;
	}

	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}



}