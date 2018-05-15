package cn.bugcatch.quickstart.core.config;

import java.util.Properties;

import org.apache.ibatis.logging.slf4j.Slf4jImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.pagehelper.PageInterceptor;
/**
 * mybatis 配置类
 * @author gao
 *
 */
@Configuration
@MapperScan("cn.bugcatch.quickstart.**.dao")//扫描包路径下所有映射文件,注意：配置的包路径下的所有接口都将被mybatis生成为一个动态代理mapper bean,推荐此路径尽量设置的精确些(或设置annotationClass来筛选指定注解的接口,markerInterface属性也可以起到过滤作用 )，免得与spring的bean造成冲突
public class MybatisConfig {
	/**
     * 通过自定义mybatis配置,不再需要xml配置文件
     * @return
     */
    @Bean
    public ConfigurationCustomizer mybatisConfigurationCustomizer() {
        return new ConfigurationCustomizer() {
			@Override
			public void customize(org.apache.ibatis.session.Configuration configuration) {
				//configuration.setLogImpl(Slf4jImpl.class);//日志实现类
				configuration.setUseGeneratedKeys(true);
				configuration.setLazyLoadingEnabled(true);
				//配置mybatis拦截器
				PageInterceptor pageInterceptor= new PageInterceptor();//分页拦截器
				/*此分页插件配置暂时未考虑多数据源的情况，后期处理数据库读写分离时 再说*/
				Properties properties = new Properties();//分页拦截器参数配置
				properties.setProperty("pageSizeZero", "true");//当该参数设置为 true 时，如果 pageSize=0 或者 RowBounds.limit = 0 就会查询出全部的结果
				properties.setProperty("reasonable", "true");//pageNum<=0 时会查询第一页， pageNum>pages（超过总数时），会查询最后一页
				pageInterceptor.setProperties(properties);
				configuration.addInterceptor(pageInterceptor);
			}
        };
    }
}
