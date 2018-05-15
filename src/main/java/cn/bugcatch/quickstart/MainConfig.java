package cn.bugcatch.quickstart;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * 主配置类
 * @author Administrator
 *
 */
//@Configuration//springboot文档上有这么一句话：通常定义了main方法的类也是使用@Configuration注解的一个很好的替补,所以这里就不需要了
@ComponentScan//不需要指定扫描路径，原因见下面注释。它同时也将扫描@Configuration类，所以不需要手动@Import了
//通常建议将应用的main类放到其他类所在包的顶层(root package)，并将@EnableAutoConfiguration注解到你的main类上，这样就隐式地定义了一个基础的包搜索路径
@EnableAutoConfiguration
//导入基于xml的事务配置(因基于注解的事务操作太过频繁)
@ImportResource("classpath:config/spring-transaction.xml")
public class MainConfig implements  CommandLineRunner, DisposableBean{
	/**
	 * 注意：spring boot项目只能存在一个main类，否则打jar包将失败
	 */
    public static void main(String[] args) throws Exception {
    	SpringApplication app = new SpringApplication(MainConfig.class);
    	app.setBannerMode(Banner.Mode.OFF);//关闭banner
    	Map<String,Object> properties= new HashMap<>();//相当于application.properties
    	properties.put("name", "gaojunming");
    	//properties.put("trace", true);
    	app.setDefaultProperties(properties);
    	//app.setAdditionalProfiles("dev");//相当于application.properties中的spring.profiles.active
    	ConfigurableApplicationContext cac= app.run(args);
    	System.out.println(cac);
    	String[] beanNames =  cac.getBeanDefinitionNames();

    	System.out.println("所以beanNames个数："+beanNames.length);

    	for(String bn:beanNames){
	    	System.out.println("class: "+cac.getBean(bn).getClass());
	        System.out.println(bn);
	    }
    	//System.out.println(new File("/tmp/spring.log").getAbsolutePath());
    	/*Map<String, String> map = System.getenv();
        for(Iterator<String> itr = map.keySet().iterator();itr.hasNext();){
            String key = itr.next();
            System.out.println(key + "=" + map.get(key));
        }   */
        System.getProperty("java.io.tmpdir");
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
