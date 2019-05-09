package UsageCaculator.Security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import UsageCaculator.Security.Model.JwtUser;
import UsageCaculator.Security.Model.MyAuthenticationToken;
import UsageCaculator.Security.Model.MyUserDetails;
import UsageCaculator.Security.SSO.SSOTokenUtil;

@Component
public class MyAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
//如果你有自己的驗證實作方式，可以自行定義 AuthenticationProvider。

	@Autowired
	private SSOTokenUtil validator;

	// 給其他api呼叫
	public String token;
	public String OrgsPip;
	public List<String> Orgs;

	// authenticate 會呼叫抽象方法 retrieveUser 取得 UserDetails
	@Override
	protected UserDetails retrieveUser(String username,
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

		MyAuthenticationToken jwtAuthenticationToken = (MyAuthenticationToken) usernamePasswordAuthenticationToken;
		String token = jwtAuthenticationToken.getToken();
		this.token = token;

//		System.out.println("---username:" + username);
//		System.out.println("---usernamePasswordAuthenticationToken:" + usernamePasswordAuthenticationToken);
//		System.out.println("---token:" + token);

		JwtUser jwtuser = validator.validate(token);

		// project
		String OrgsPip =validator.getOrgsPip(token);
		List<String> Orgs = validator.getOrgs(token);
		System.out.println("getOrgsPip=" + OrgsPip);
		System.out.println("getOrgs=" + Orgs);

		if (jwtuser == null) {
			throw new RuntimeException("JWT Token is incorrect");
		}

		// GrantedAuthority是用戶權限信息對象，這個對象中定義了一個獲取用戶權限描述信息的getAuthority方法。
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList(jwtuser.getRole()); // ex:ROLE_USER

		return new MyUserDetails(token, grantedAuthorities, OrgsPip, OrgsPip, Orgs);
//		return new MyUserDetails();
	}

	// 在 AbstractUserDetailsAuthenticationProvider 的實作中，authenticate 會呼叫抽象方法
	// retrieveUser 取得 UserDetails，然後呼叫抽象方法 additionalAuthenticationChecks 來進行驗證：
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
		// UsernamePasswordAuthenticationToken实现了Authentication，主要是将用户输入的用户名密码进行封装，并提供给
		// AuthenticationManager进行验证，验证成功后，返回一个认证成功的UsernamePasswordAuthenticationToken对象
		// additionalAuthenticationChecks:
		// Allows subclasses to perform any additional checks of a returned (or cached)
		// UserDetails for a given authentication request.

	}

	// AuthenticationProvider的supports函数返回true，那么就会调用该AuthenticationProvider的authenticate函数认证，如果认证成功则整个认证过程结束。如果不成功，则继续使用下一个合适的AuthenticationProvider进行认证
	@Override
	public boolean supports(Class<?> aClass) {
		return (MyAuthenticationToken.class.isAssignableFrom(aClass));// Returns true if this AuthenticationProvider
																		// supports the indicated Authentication object.
		// Class.isAssignableFrom() 是用来判断一个类 Class1 和另一个类 Class2 是否相同或是另一个类的超类
		// superclass 或接口 superinterface。
	}
}

/*
 * 在 AbstractUserDetailsAuthenticationProvider 的實作中 authenticate 會呼叫抽象方法
 * retrieveUser 取得 UserDetails，然後呼叫抽象方法 additionalAuthenticationChecks 來進行驗證：
 */
