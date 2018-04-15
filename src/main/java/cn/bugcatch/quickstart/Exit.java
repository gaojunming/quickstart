package cn.bugcatch.quickstart;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
/**
 * 强制关闭项目时无法触发此销毁事件。
 * 目前可用的解决方案是在ide外部通过cmd命令行执行 mvn spring-boot:run命令(或者直接打包)来启动项目，然后ctrl+c来正常退出项目服务。
 */
import org.springframework.stereotype.Component;
@Component
public class Exit implements  DisposableBean{
	@Override
	public void destroy() throws Exception {
		System.err.println("destroy");
	}


}
