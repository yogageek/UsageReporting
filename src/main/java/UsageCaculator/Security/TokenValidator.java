//package UsageCaculator.Security;
//
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.stereotype.Component;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.interfaces.Claim;
//import com.auth0.jwt.interfaces.DecodedJWT;
//
//import UsageCaculator.Security.Model.JwtUser;
//
//@Component
////在這裡把token包含的需要用到之資料拿出來
//public class TokenValidator {
//
//	static String OrgIdRegex = "[a-zA-Z_0-9]{8}-[a-zA-Z_0-9]{4}-[a-zA-Z_0-9]{4}-[a-zA-Z_0-9]{4}-[a-zA-Z_0-9]{12}";
//
//	public JwtUser validate(String token) {
//		JwtUser jwtuser = null;
//		try {
//			DecodedJWT jwt = JWT.decode(token);
//			Map<String, Claim> claims = jwt.getClaims();
//			Claim claim = claims.get("role");
//			jwtuser = new JwtUser();
//			String theRole = "ROLE_" + claim.asString().toUpperCase();
//			jwtuser.setRole(theRole);
//			System.out.println("jwtuser:" + theRole);
//
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		return jwtuser;
//	}
//
//	// 取出token的group (sso資訊)
//	public String getSsoorgs(String token) {
//		String orgs = getOrgsPip(token);// sso token中的org就是groups標籤 //getOrgsPip 如果使用者下all 要取反查他的org有哪些--security 先做
//		System.out.println("MyAuthenticationProvider.java--getSsoorgs---getOrgsPip--orgs:" + orgs);
//		if (orgs.length() > 0)
//			return orgs;
//		return "";
//	}
//
//	// 解析token的org(group)
//	public static List<String> getOrgs(String token) {// 回傳list: a,b,c
//		try {
//			DecodedJWT jwt = JWT.decode(token);
//			Map<String, Claim> claims = jwt.getClaims(); // Key is the Claim name
//			Claim iss = claims.get("iss");
//
//			if (iss.asString().equals(System.getenv("SSO_ISS"))) {
//				Claim claim = claims.get("groups");
//				return claim.asList(String.class);// If the value isn't an Array, null will be returned.
//			} else {
//				System.out.println("------TokenValidator.java---getOrgs---擁有的Org(group)權限為null");
//				return null;
//			}
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			return null;
//		}
//	}
//
//	public static String getOrgsPip(String token) {// 讓getOrgs傳來的list變成string回傳 :"a,b,c,..."
//		List<String> orgs = getOrgs(token);// token中的groups標籤 是LIST型態 可能有多個 :a,b,c
//		String orgPip = "";
//		if (orgs != null) {
//			for (int i = 0; i < orgs.size(); i++) {
//				if (orgs.get(i).matches(OrgIdRegex)) {// 檢查a,b,c是否都符合規則
//					if (orgPip.length() > 0) {
//						// have id
//						orgPip += ",";
//					}
//					orgPip += orgs.get(i);
//				}
//			}
//		}
//		return orgPip;
//	}
//
//}
