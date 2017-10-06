package other;

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

public class AdminCheck extends AbstractInterceptor implements ServletRequestAware {

	String result = "login";
	
	HttpServletRequest request;
	HttpSession session;



	int mem_id = 0;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		session = ServletActionContext.getRequest().getSession(false);
		System.out.println(session + "tesssst1");
		
		try{
			mem_id = ((Integer)(session.getAttribute("mem_lev"))).intValue();
			System.out.println(mem_id + "tesssst2");
			
			if ( mem_id == 3) {
	   			result = invocation.invoke();
	   		} 
			
		} catch (Exception ex) {
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