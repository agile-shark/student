package cn.edu.ccdx.student.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.edu.ccdx.student.action.StudentAction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


public class AuthInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;
	public static final String LOGIN_KEY = "LOGIN";
	public static final String LOGIN_PAGE = "inputpage";

	//过滤用户权限，即是否符合登录的权限
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ac = invocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) ac
				.get(ServletActionContext.HTTP_REQUEST);
		Object action = invocation.getAction();
		if (action instanceof StudentAction) {
			return invocation.invoke();
		}
		
		Map session = invocation.getInvocationContext().getSession();
		String user = (String) session.get("student_name");
		if (null != user) {
			return invocation.invoke();
		} else {
			return LOGIN_PAGE;
		}
	}

}
