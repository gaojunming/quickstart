package cn.bugcatch.quickstart;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import cn.bugcatch.quickstart.error.MyError;
@ComponentScan//不需要指定扫描路径，原因见下面注释
//@Configuration//springboot文档上有这么一句话：通常定义了main方法的类也是使用@Configuration注解的一个很好的替补,所以这里就不需要了
//通常建议将应用的main类放到其他类所在包的顶层(root package)，并将@EnableAutoConfiguration注解到你的main类上，这样就隐式地定义了一个基础的包搜索路径
@EnableAutoConfiguration
@Profile("dev")//此注解的作用与application-dev.properties属性文件类似，声明只有在dev Profile被激活时当前配置类才会生效(此处只是demo，实际使用应放在有意义的配置类文件中，比如jdbc配置信息)
public class App {

	/**
	 * 注意：spring boot项目只能存在一个main类，否则打jar包将失败
	 */
    public static void main(String[] args) throws Exception {
    	SpringApplication app = new SpringApplication(App.class);
    	app.setBannerMode(Banner.Mode.OFF);//关闭banner
    	Map<String,Object> properties= new HashMap<>();//相当于application.properties
    	properties.put("name", "gaojunming");
    	//properties.put("trace", true);
    	app.setDefaultProperties(properties);
    	//app.setAdditionalProfiles("dev");//相当于application.properties中的spring.profiles.active
    	app.run(args);
    }
}
