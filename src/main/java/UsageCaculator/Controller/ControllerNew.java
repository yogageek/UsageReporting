package UsageCaculator.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grafana")

public class ControllerNew {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());// 使用指定类初始化日志对象

	@RequestMapping(value = "/query", method = RequestMethod.POST) // @RequestHeader:獲取HTTP報文中 //
																	// 屬性為Authorization的值 用法同@RequestParam
	public Object query(@RequestBody String test) {
		
		System.out.println("into controller");
		String rtn="controller return to web hello";
		return rtn; 
	}
}
