package cn.bugcatch.quickstart.core.config;

import java.util.Date;
import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Profile;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Controller;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import cn.bugcatch.quickstart.core.FrontInterceptor;
import cn.bugcatch.quickstart.core.MyServlet;


/**
 * 此配置用于扩展mvc配置
* @author gjm
* @date 2018年4月15日 上午12:35:22
* @describe
*/
@Configuration
//如果想放弃spring boot mvc默认添加的特性，你可以添加自己的@Configuration，并使用@EnableWebMvc注解来全面控制Spring MVC。当前选择是保留默认特性，并增加其他mvc配置
//@EnableWebMvc
@Profile("dev")//此注解的作用与application-dev.properties属性文件类似，声明只有在dev Profile被激活时当前配置类才会生效(此处只是demo，实际使用应放在有意义的配置类文件中，比如jdbc配置信息)
public class MyWebMvcConfig extends WebMvcConfigurerAdapter{
	/**
     * 自定义servlet上下文初始化器，onStartup中获取servletcontext可注册servlet、filter、lisent
     * @return
     */
    @Bean
    public ServletContextInitializer myServletContextInitializer() {
    	return new ServletContextInitializer() {
			@Override
			public void onStartup(ServletContext servletContext) throws ServletException {
				
				javax.servlet.ServletRegistration.Dynamic dyn= servletContext.addServlet("myser", MyServlet.class);
				dyn.addMapping("/hello");
				
				javax.servlet.FilterRegistration.Dynamic dyn2= servletContext.addFilter("HiddenHttpMethodFilter", HiddenHttpMethodFilter.class);
				dyn2.addMappingForServletNames(EnumSet.allOf(DispatcherType.class), false, "dispatcherServlet");//使用dispatcherServlet默认名称
			}
		};
    }
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//拦截所有控制器请求，排除掉admin下的
		registry.addInterceptor(new FrontInterceptor()).addPathPatterns("/**").excludePathPatterns("/admin/**");
	}

}
