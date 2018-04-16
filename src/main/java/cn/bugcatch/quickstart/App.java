package cn.bugcatch.quickstart;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
/**
 * 主配置类
 * @author Administrator
 *
 */
@ComponentScan//不需要指定扫描路径，原因见下面注释
//@Configuration//springboot文档上有这么一句话：通常定义了main方法的类也是使用@Configuration注解的一个很好的替补,所以这里就不需要了
//通常建议将应用的main类放到其他类所在包的顶层(root package)，并将@EnableAutoConfiguration注解到你的main类上，这样就隐式地定义了一个基础的包搜索路径
@EnableAutoConfiguration
public class App implements  CommandLineRunner, DisposableBean{
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
    /**
     * 项目退出时执行
     */
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.err.println("destroy");
	}
	@Value("${hello}${name} ${haha}")
	private String name;
	/**
	 * 项目启动后执行
	 */
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.err.println(name+" start:"+Arrays.toString(args));
	}
}
