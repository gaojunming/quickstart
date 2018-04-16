package cn.bugcatch.quickstart.context;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import cn.bugcatch.quickstart.interceptor.FrontInterceptor;


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
public class ExtendWebMvcConfigurer extends WebMvcConfigurerAdapter{
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//拦截所有控制器请求，排除掉admin下的
		registry.addInterceptor(new FrontInterceptor()).addPathPatterns("/**").excludePathPatterns("/admin/**");
	}

}
