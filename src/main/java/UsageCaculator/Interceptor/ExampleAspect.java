package UsageCaculator.Interceptor;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;

import UsageCaculator.Model.QueryRequest;
import UsageCaculator.Model.QueryTargetType;
import UsageCaculator.Security.MyAuthenticationProvider;

@Aspect
@Component
public class ExampleAspect {

//	@Autowired
//	MyUserDetails user; //error
//	@Autowired
//	MyAuthenticationToken tokenProvider;

	@Autowired
	MyAuthenticationProvider tokenInfoProvider;

	private static Logger logger = LoggerFactory.getLogger(ExampleAspect.class);

	// 方法表达式以“*”号开始 代表 返回任意類型
	// 两个点好(..)表明切点要选择任意的 test()方法，无论该方法的参数是什么
	@Around("execution(* UsageCaculator.Controller.ControllerNew.query(..))")
	public Object aroundAspect(ProceedingJoinPoint joinPoint) {
		// 获取request 可以从中获取参数或cookie
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes) ra;
		HttpServletRequest request = sra.getRequest();
//----------------------------------------------------------------------------------
		String url = request.getRequestURL().toString();
		String method = request.getMethod();
		String queryString = request.getQueryString();
		logger.info("{url:{}, method:{}, queryString:{}}", url, method, queryString);
//----------------------------------------------------------------------------------
		Object[] args = joinPoint.getArgs();
		Object object = args[0];
		String strArg = object.toString();
//		System.out.println(strArg);
		Object result = null;
		ObjectMapper mapper = new ObjectMapper();
//----------------------------------------------------------------------------------
		try {
//			Object proceed = joinPoint.proceed();//not sure, controller will exec only sysout but not return
			try {
				QueryRequest queryRequest = mapper.readValue(strArg, QueryRequest.class);
				// 在這裡取出orgId做驗證
				for (QueryTargetType target : queryRequest.getTargets()) {

					String orgId = target.getOrganizationId();
					System.out.println("orgId=" + orgId);
					System.out.println("----------------------待修改-----------------------");

					// orgPip=有權限的org(在user token裡)					
					String orgPip = tokenInfoProvider.OrgsPip;// 查詢token group 帶出可查的 orgs --"能夠查的"
					System.out.println("orgPip=" + orgPip);
					if(orgPip==null) {
						return "You have no any org authenrization";
					}					

					// 一定能查,除非org不存在
					if (orgId == "all") {
						System.out.println("------orgId:=all");
						// org不存在
						if (orgPip.length() <= 0) {
							result = "No org Error.";
							return result;
						}
						// target.setOrganizationId(orgPip);//controller去做
					}

					// 查多個org 比對要查的org是否有在token權限中
					if (orgId.contains(",")) {// not finish yet
						System.out.println("------orgId:multi");						
						List<String> ssoOrgs=tokenInfoProvider.Orgs;
						StringTokenizer orgsSt = new StringTokenizer(orgId);
						while (orgsSt.hasMoreElements()) {
							String orgToken = orgsSt.nextToken();
							if (!ssoOrgs.contains(orgToken)) {
								return "You do not have permission to query org: " + orgToken;
							}
						}
					}
					// 如果非以上(只查一個org)
					else {
						System.out.println("------orgId:one");
						if (!orgPip.equals(orgId)) {
							result = "You do not have permission to query org:" + orgId;
							return result;
						}
					}
				}
				System.out.println("--------for 結束---------");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;// return null 就會繼續執行controller，否則中斷執行controller並return result
	}


	@Around("@annotation(LogExecutionTime)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

		long start = System.currentTimeMillis();

		Object proceed = joinPoint.proceed();

		long executionTime = System.currentTimeMillis() - start;

		System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
		return proceed;
	}

}

//for (Object arg: args) {
//System.out.println("Arg: " + arg);		    
//}
//for (int i = 0; i < args.length; i++) {
//System.out.println(i + ":" + args[i]);// 0:{"format":"json"}
//}

//JSONArray array=JSONArray.fromObject(object);
//JSONObject object=JSONObject.fromObject(object);		
//JSONObject Object= new JSONObject(strArg);

//Gson gson = new Gson();
//QueryRequest queryRequest = gson.fromJson(args, QueryRequest.class);

//StringBuilder sb = new StringBuilder();
//StringBuilder stringBuilder = new StringBuilder();
//Arrays.stream(args).forEach(object -> stringBuilder.append(object.toString().replace("=", ":")));
//if (stringBuilder.length() == 0) {
//	stringBuilder.append("{}");
//}
//sb.append(stringBuilder.toString());
//String s = sb.toString();
//logger.info(sb.toString());
