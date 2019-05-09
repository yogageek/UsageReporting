package UsageCaculator.Security;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class SeurityConfig extends WebSecurityConfigurerAdapter {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());// 使用指定类初始化日志对象    

	@Autowired
	private MyAuthenticationProvider authenticationProvider;
	@Autowired
	private MyAuthenticationEntryPoint entryPoint;
//    @Autowired
//    MyAccessDeniedHandler myAccessDeniedHandler;

	@Bean
	public AuthenticationManager authenticationManager() {// authenticationManager: to authenticate a user in the login

		return new ProviderManager(Collections.singletonList(authenticationProvider));
	}
	
	
	
	
	@Bean
	public AuthenticationFilter authenticationTokenFilter() {
	        AuthenticationFilter filter = new AuthenticationFilter();
	        filter.setAuthenticationManager(authenticationManager());//加入 執行認證事件
	        filter.setAuthenticationSuccessHandler(new MySuccessHandler());//加入  認證成功後事件
	        return filter;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.csrf().disable()
		 .authorizeRequests()		 
		 .antMatchers("/").permitAll()//允许所有用户访问"/"
		 //"/grafana/simplejson/query"
		 .anyRequest()//對象為所有網址
//		 .antMatchers("/grafana/**")//對象為指定網址
		 .authenticated()//存取必須通過驗證 沒通過會跳401 
		 .and()
		 .exceptionHandling().authenticationEntryPoint(entryPoint)//指定頁面跳出的錯誤訊息		 
         .and()
//       .and().exceptionHandling().accessDeniedHandler(myAccessDeniedHandler)		 
		 .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);//调整为让 Spring Security 不创建和使用 session
		 http.addFilterBefore(authenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
		 http.headers().cacheControl();
		//-------------------------------
//		http.
//		authorizeRequests()
//		.anyRequest() //對象為所有網址
//		.authenticated() //存取必須通過驗證
//		.and()
//		.formLogin() //若未不符合authorize條件，則產生預設login表單
//		.and()
//		.httpBasic(); //產生基本表單
		//-------------------------
//		 http.csrf().disable()
//         .authorizeRequests().antMatchers("**/rest/**").authenticated()
//         .and()
//         .exceptionHandling().authenticationEntryPoint(entryPoint)
//         .and()
//         .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		 
//		 http.addFilterBefore(authenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//		 http.headers().cacheControl();
		

//		super.configure(http);
	}

//	@Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//        UserDetails user =User.withUsername("user").password("ps").roles("USER").build();
//                
//
//        return new InMemoryUserDetailsManager(user);
//	}

//	@Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//		 UserDetails user =
//		         User.withDefaultPasswordEncoder()
//		            .username("user")
//		            .password("password")
//		            .roles("USER")
//		            .build();
//		return new InMemoryUserDetailsManager(users);
//	}

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth
//		.inMemoryAuthentication().withUser("user").password("123").roles("USER");
//	}

}
