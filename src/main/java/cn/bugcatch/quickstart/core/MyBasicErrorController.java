package cn.bugcatch.quickstart.core;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ErrorViewResolver;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 扩展的错误控制器
 * 另外可通过继承DefaultErrorAttributes或实现ErrorAttributes来自定义错误数据内容，
 * 也可以定义一个@ControllerAdvice去自定义某个特殊controller或exception类型的错误数据内容
 * 也可以为特定的状态码自定义错误页面，404哪个页面，5xx哪个页面，详细说明见https://qbgbook.gitbooks.io/spring-boot-reference-guide-zh/content/IV.%20Spring%20Boot%20features/27.1.8%20Error%20Handling.html
* @author gjm
* @date 2018年4月15日 下午11:20:54
* @describe
*/
@Component
public class MyBasicErrorController extends BasicErrorController{

	//构造器注入参数
	public MyBasicErrorController(ErrorAttributes errorAttributes,ServerProperties serverProperties,
			ObjectProvider<List<ErrorViewResolver>> errorViewResolversProvider) {
		super(errorAttributes, serverProperties.getError(), errorViewResolversProvider.getIfAvailable());
	}
	/**
	 * 扩展的错误返回类型，如果请求内容是xml，那么返回xml数据
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(produces = "application/xml")
	public ResponseEntity<Map<String, Object>> errorXml(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> body = getErrorAttributes(request,
				isIncludeStackTrace(request, MediaType.APPLICATION_XML));
		HttpStatus status = getStatus(request);
		return new ResponseEntity<Map<String, Object>>(body, status);
	}

}
