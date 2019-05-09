package UsageCaculator.Security.Model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class MyAuthenticationToken extends UsernamePasswordAuthenticationToken {
	
//	@Autowired
//	private TokenValidator validator;
	
	
	//自定义的一个字段
	private String token;			
//	private String stringOrgs;
//	private List<String> listOrgs;
	
	//使用field生成构造方法1
	public MyAuthenticationToken(String token) {
		super(null, null);// 因為父類別初始需要有參數的建構子 所以子類別必須滿足它
		this.token = token;
//		this.stringOrgs = validator.getSsoorgs(token);
//		this.listOrgs= validator.getOrgs(token);
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public Object getCredentials() {
		return null;
	}

	@Override
	public Object getPrincipal() {
		return null;
	}
	
	
	
	/*
	 * @Override public void setAuthenticated(boolean isAuthenticated) throws
	 * IllegalArgumentException { // TODO Auto-generated method stub //
	 * super.setAuthenticated(isAuthenticated); return null; }
	 * 
	 * @Override public void eraseCredentials() { // TODO Auto-generated method stub
	 * // super.eraseCredentials(); return null; }
	 */

}
