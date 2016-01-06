package nuaa.ggx.pos.frontend.web.auth;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录状态信息系的工具类
 * @author RY
 * 2016年1月6日
 */
public class AuthHelper {
	
	public static void setSessionAccountAuth(HttpServletRequest request, AccountAuth accountAuth){
		request.getSession().setAttribute("accountAuth", accountAuth);
	}
	
	public static AccountAuth getSessionAccountAuth(HttpServletRequest request){
		return (AccountAuth)request.getSession().getAttribute("accountAuth");
	}
	
	public static void removeSessionAccountAuth(HttpServletRequest request){
		request.getSession().removeAttribute("accountAuth");
	}
}
