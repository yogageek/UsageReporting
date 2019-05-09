package UsageCaculator.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import UsageCaculator.Security.Model.MyUserDetails;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 调用成功处理器，可以自己实现AuthenticationSuccessHandler接口重写方法写自己的逻辑，在JwtSecurityConfig configure 中 addfilter
public class MySuccessHandler implements AuthenticationSuccessHandler{
	@Autowired
	private MyUserDetails myu; 
    
	
	@Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        System.out.println("Successfully Authentication");        
       
        
        
        
    }
}



