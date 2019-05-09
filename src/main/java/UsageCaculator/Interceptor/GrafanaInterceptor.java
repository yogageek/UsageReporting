//package UsageCaculator.Interceptor;
//
//import java.util.List;
//import java.util.StringTokenizer;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.MethodParameter;
//import org.springframework.web.context.request.RequestAttributes;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import UsageCaculator.Security.Model.MyUserDetails;
//
//public class GrafanaInterceptor extends HandlerInterceptorAdapter {
//
////	@Autowired
////	UsageServiceNew usageServiceNew;
//
//	@Autowired
//	MyUserDetails user;
//
//	// 檢查orgs權限
//	public boolean checkOrgAuthtication(String queryOrgId) {
//		String orgPip = user.getStringOrgs();// 查詢token("group")帶出可查的orgs權限--- "能夠查的"
//		List orgPips = user.getListOrgs();
//
//		StringTokenizer orgsSt = new StringTokenizer(queryOrgId); // 要查的
//		while (orgsSt.hasMoreElements()) {
//			String orgToken = orgsSt.nextToken();
//			if (!orgPips.contains(orgToken)) {
//				return false;
//			}
//		}
//		return true;
//	}
//
//	// 會在Controller執行前被呼叫，可預先執行編碼或安全控制等，回傳的boolean值決定是否繼續執行，回傳”true”會繼續執行流程
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		// 1
//		// 取得參數方法
////	    HandlerMethod handlerMethod = (HandlerMethod) handler;
////	    MethodParameter[] methodParameters = handlerMethod.getMethodParameters();
////	    System.out.println(methodParameters.toString());
////		 System.out.println("*********************preHandle********************");  
////		    System.out.println(handler.getClass());  
////		    HandlerMethod handlerMethod = (HandlerMethod) handler;  
////		    System.out.println(handlerMethod.getMethod());
//		
//		    
////		 logger.info("request請求地址path[{}] uri[{}]", request.getServletPath(),request.getRequestURI());
////	        //request.getHeader(String) 從請求頭中獲取資料
////	        //從請求頭中獲取使用者token（登陸憑證根據業務而定）
////	        Long userId= getUserId(request.getHeader("H-User-Token"));
//		    
////	    // Inspect & log parameters...
//		
////		RequestAttributes reqAttr = RequestContextHolder.getRequestAttributes();
////		HttpServletRequest req = ((ServletRequestAttributes) reqAttr).getRequest();
//		System.out.println(request.getHeader("Authorization"));
////		System.out.println(request.getParameterValues());
//		
//		// 2		
//			String orgId = request.getParameter("format");// request.getParameterValues("org") //取[]用
//			System.out.println("orgId="+orgId);
//			if(orgId==null) {
//				orgId="";
//			}
//			String orgPip = user.getStringOrgs();// 查詢token group 帶出可查的 orgs --"能夠查的"
//			System.out.println("orgPip="+orgPip);
//			if(orgPip==null) {
//				orgPip="";
//			}
//
//			// 一定能查
//			if (orgId == "all") {
//				System.out.println("------orgId:=all");
////			QueryTargetType target = new QueryTargetType();
////			target.setOrganizationId(orgPip); 
//				return true;
//			}
//			// 查多個org 比對要查的org是否有在token權限中
//			if (orgId.contains(",")) {
//				System.out.println("------orgId:multi");
//				if (checkOrgAuthtication(orgId)) {
//					return true;
//				}
//				return false;
//			}
//
//			// 如果只有查一個org
//			if (!orgPip.equals(orgId)) {
//				System.out.println("------orgId:one");
//				return false;
//			}		
//		return true;
//
//	}
//
//	// 會在Controller執行後被呼叫，有機會修改ModelAndView。
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		// TODO Auto-generated method stub
//	}
//
//	// 會在view繪製完成後被呼叫，可依據Exception來作處理，Exception從底層向外拋出，最後到spring框架到這個method中。
//	@Override
//	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
//			throws Exception {
//		// TODO Auto-generated method stub
//	}
//}