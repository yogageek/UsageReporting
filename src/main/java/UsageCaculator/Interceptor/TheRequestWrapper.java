//package UsageCaculator.Interceptor;
//
//import java.lang.reflect.Type;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.core.MethodParameter;
//import org.springframework.http.HttpInputMessage;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;
//
//import UsageCaculator.Controller.ControllerNew;
//import UsageCaculator.Model.QueryRequest;
//
//@ControllerAdvice(assignableTypes = ControllerNew.class)
//public class TheRequestWrapper extends RequestBodyAdviceAdapter {
//
//	private static final Logger logger = LoggerFactory.getLogger(TheRequestWrapper.class);
//
//	@Override
//	public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType,
//			Class<? extends HttpMessageConverter<?>> converterType) {
//		logger.info("CustomRequestAdvice afterBodyRead");
//
//		System.out.println("可针对读取后的对象做转换，此处不做处理");
//		
//		System.out.println(parameter.getMethod().getParameterAnnotations());
//		
//		
//		QueryRequest q = (QueryRequest) body;
////		q.getTargets()
//        
//         return body;
//		
//		
//		
//		return body;
//	}
//
//	@Override
//	public boolean supports(MethodParameter methodParameter, Type targetType,
//			Class<? extends HttpMessageConverter<?>> converterType) {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//}