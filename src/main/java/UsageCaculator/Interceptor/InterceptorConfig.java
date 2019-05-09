package UsageCaculator.Interceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
	  
	//配置攔截器路徑
	  @Override
	  public void addInterceptors(InterceptorRegistry registry) {
//	      registry.addInterceptor(new GrafanaInterceptor()).addPathPatterns("/grafana/query");

	  }
	  
//	@Autowired 
//	 HandlerInterceptor grafanaInterceptor;
	
//	@Override
//	   public void addInterceptors(InterceptorRegistry registry) {
//	      // LogInterceptor apply to all URLs.
//	      registry.addInterceptor(new ReportingInterceptor());
//	 
//	      // Old Login url, no longer use.
//	      // Use OldURLInterceptor to redirect to a new URL.
//	      registry.addInterceptor(new OldLoginInterceptor())//
//	            .addPathPatterns("/admin/oldLogin");
//	 
//	      // This interceptor apply to URL like /admin/*
//	      // Exclude /admin/oldLogin
//	      registry.addInterceptor(new AdminInterceptor())//
//	            .addPathPatterns("/admin/*")//
//	            .excludePathPatterns("/admin/oldLogin");
//	   }
	
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new TestHandlerInterceptor())
//                //添加需要验证登录用户操作权限的请求
//                .addPathPatterns("/testContrl/create*", "/testContrl/update*", "/testContrl/delete*")
//                //排除不需要验证登录用户操作权限的请求
//                .excludePathPatterns("/userCtrl/*");
//    }  

}