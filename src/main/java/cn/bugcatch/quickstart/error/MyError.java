package cn.bugcatch.quickstart.error;

import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
* @author gjm
* @date 2018年4月15日 下午11:20:54
* @describe
*/
public class MyError extends BasicErrorController{

	public MyError(ErrorAttributes errorAttributes, ErrorProperties errorProperties) {
		super(errorAttributes, errorProperties);
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(produces = "application/json; charset=UTF-8")
	public void sss(HttpServletRequest request,
			HttpServletResponse response) {
		System.err.println("扩展的");
	}

}
