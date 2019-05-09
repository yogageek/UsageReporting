package UsageCaculator.Security.SSO;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import UsageCaculator.Security.Model.JwtUser;

@Component
public class SSOTokenUtil {
	static String OrgIdRegex = "[a-zA-Z_0-9]{8}-[a-zA-Z_0-9]{4}-[a-zA-Z_0-9]{4}-[a-zA-Z_0-9]{4}-[a-zA-Z_0-9]{12}";

	public static boolean isValdation(String token) {
		try {
			DecodedJWT jwt = JWT.decode(token);
			Map<String, Claim> claims = jwt.getClaims(); // Key is the Claim name
			Claim claim = claims.get("role");
			Claim iss = claims.get("iss");
			if (iss.asString().equals(System.getenv("SSO_ISS"))) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public static boolean isAdmin(String token) {
		try {
			DecodedJWT jwt = JWT.decode(token);
			Map<String, Claim> claims = jwt.getClaims(); // Key is the Claim name
			Claim claim = claims.get("role");
			if (isValdation(token)) {
				if (claim.asString().equals("admin")) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	// 解析token的org(group)
	public static List<String> getOrgs(String token) {
		try {			
			DecodedJWT jwt = JWT.decode(token);
			Map<String, Claim> claims = jwt.getClaims(); // Key is the Claim name
			Claim iss = claims.get("iss");
			//暫時修改
			Claim claim = claims.get("groups");
			return claim.asList(String.class);
//			if (iss.asString().equals(System.getenv("SSO_ISS"))) {
//				Claim claim = claims.get("groups");
//				return claim.asList(String.class);
//			} else {
//				return null;
//			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	public static String getOrgsPip(String token) {// 讓getOrgs傳來的的list變成string回傳 :"a,b,c,..."
		List<String> orgs = getOrgs(token);// token中的groups標籤 是LIST型態 可能有多個 :a,b,c
		String orgPip = "";
		if (orgs != null) {
			for (int i = 0; i < orgs.size(); i++) {
				if (orgs.get(i).matches(OrgIdRegex)) {
					if (orgPip.length() > 0) {
						// have id
						orgPip += ",";
					}
					orgPip += orgs.get(i);
				}
			}
		}
		return orgPip;
	}

	public JwtUser validate(String token) {
		JwtUser jwtuser = null;
		try {
			DecodedJWT jwt = JWT.decode(token);
			Map<String, Claim> claims = jwt.getClaims();
			Claim claim = claims.get("role");
			jwtuser = new JwtUser();
			String theRole = "ROLE_" + claim.asString().toUpperCase();
			jwtuser.setRole(theRole);
			System.out.println("jwtuser:" + theRole);

		} catch (Exception e) {
			System.out.println(e);
		}
		return jwtuser;
	}

}
