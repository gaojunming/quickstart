package cn.bugcatch.quickstart;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import cn.bugcatch.quickstart.interceptor.FrontInterceptor;


/**
* @author gjm
* @date 2018年4月15日 上午12:35:22
* @describe
*/
@Configuration
//如果想放弃spring boot mvc默认添加的特性，你可以添加自己的@Configuration，并使用@EnableWebMvc注解来全面控制Spring MVC。当前选择是保留默认特性，并增加其他mvc配置
//@EnableWebMvc
public class WebMvc extends WebMvcConfigurerAdapter{
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//拦截所有控制器请求，排除掉admin下的
		registry.addInterceptor(new FrontInterceptor()).addPathPatterns("/**").excludePathPatterns("/admin/**");
	}

}
