package UsageCaculator.Security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import UsageCaculator.Security.Model.MyAuthenticationToken;

public class AuthenticationFilter extends AbstractAuthenticationProcessingFilter {

	protected AuthenticationFilter() {
				
		super("/grafana/**"); //要擋下的網址   ..super?->填補父類別
		
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		
		//1.reads JWT authentication token from the Authorization header of all the requests  
        String header = request.getHeader("Authorization");       
        //header="Token eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJhbGktd2lzZXBhYXMiLCJpYXQiOjE1NTU5MjY2NDUsImV4cCI6MTU1NTkzMDI0NSwidXNlcklkIjoiM2MzZjZiODEtODhlMy00ZTBiLTgxMDAtNjA2YmYxNmZkZDZjIiwidWFhSWQiOiI3MzkwMzEwYS05NDcwLTQ0ZGMtODNjYS05NDkyMmE1ZDliYzEiLCJjcmVhdGlvblRpbWUiOjE1NTU0OTE3NjYwMDAsImxhc3RNb2RpZmllZFRpbWUiOjE1NTU5MTQ2MDYwMDAsInVzZXJuYW1lIjoiQ2hpZW5Ic2lhbmcuQ2hlbkBhZHZhbnRlY2guY29tLnR3IiwiZmlyc3ROYW1lIjoiQ2hpZW5Ic2lhbmciLCJsYXN0TmFtZSI6IkNoZW4iLCJjb3VudHJ5IjoiVFciLCJyb2xlIjoiYWRtaW4iLCJncm91cHMiOlsiY2luZHljeXdhbmdAaWlpLm9yZy50dyJdLCJjZlNjb3BlcyI6W3siZ3VpZCI6bnVsbCwic3NvX3JvbGUiOiJhZG1pbiIsInNwYWNlcyI6W119XSwic2NvcGVzIjpbXSwic3RhdHVzIjoiYWN0aXZlIiwib3JpZ2luIjoiU1NPIiwib3ZlclBhZGRpbmciOmZhbHNlLCJzeXN0ZW0iOmZhbHNlLCJyZWZyZXNoVG9rZW4iOiIyYmM4NWYyYy0yOWQ1LTQ0NjgtOTBlMy03Nzg0OGZmY2VkYWMifQ.S24HogcWs-qNRzIqhLp11_qlkY7xUeSnzilqQGgiqE5i9-5LX_q9iRWN5d9n9RrXVw89WoE6gy_uPwV6JMbFOg";               
        
        //2.validates the token
        if (header == null) {
            throw new RuntimeException("JWT Token is missing");
        }
        
        //3.loads the user details associated with that token
        String authenticationToken = header.substring(6);//拿掉前面token or bearer開頭
        MyAuthenticationToken token = new MyAuthenticationToken(authenticationToken);        
        return getAuthenticationManager().authenticate(token);
        
	}
	
	//???
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
		super.successfulAuthentication(request, response, chain, authResult);
		chain.doFilter(request, response);
		// Filter 介面的 doFilter() 方法則類似於 Servlet 介面的 service() 方法。
		// 當請求來到容器，而容器發現呼叫 Servlet 的 service() 方法前，可以套用某過濾器時，就會呼叫該過濾器的 doFilter() 方法。
		// 你就是在 doFilter() 方法中，進行 service() 方法的前置處理，而後決定是否呼叫 FilterChain 的 doFilter()方法。
	}

}
