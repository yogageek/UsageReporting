//package UsageCaculator.Security;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MyAccessDeniedHandler implements AccessDeniedHandler {
//
//    //如果寫了這個類別 被攔截的話前端就會空白 要自己做處理
//    @Override
//    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
//        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//        response.setContentType("application/json;charset=UTF-8");
//        System.out.println("---MyAccessDeniedHandler");
//    }
//}
