mvn spring-boot:run 启动项目 	eclipse中debug时不要使用 ，否则看不到框架源码。推荐在main方法中执行debug

mvn package	给项目打jar包 

java -jar xxx.jar	执行java程序

目前项目配置支持thymeleaf和freemarker两种模板引擎，默认情况下freemarker和thymeleaf模板视图解析器的顺序是相同的，但是freemarker先于thymeleaf加入到视图解析器链中，所以在模板同名的情况下freemarker会优先于thymeleaf被使用，此顺序可通过配置文件修改顺序


关于字符串日期时间参数转换java Date的 实现方式推荐这三种：实现converter或formatter或注解@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")

待处理：
	文件上传
	