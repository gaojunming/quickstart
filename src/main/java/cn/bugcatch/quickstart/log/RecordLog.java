package cn.bugcatch.quickstart.log;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;


/**
 * 日志记录切面
 * @author gao
 *
 */
@Component
@Aspect
public class RecordLog {
	//@Resource
    //private SystemOperateLogService systemOperateLogService;
	/**
	 * 连接点成功返回之后通知
	 * @param joinPoint
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	//@AfterReturning
	@AfterThrowing(pointcut="execution(* cn.bugcatch.quickstart..*.*(..)) && @annotation(cn.bugcatch.quickstart.log.Record)")
	public void record(JoinPoint joinPoint) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		System.err.println("日志记录..");
		/*Signature signature= joinPoint.getSignature();//签名对象，用于获取连接点信息
		if(signature instanceof MethodSignature) {
			Session session= SecurityUtils.getSubject().getSession();//当前会话对象
			MethodSignature methodSignature= (MethodSignature) signature;
			Record record= methodSignature.getMethod().getAnnotation(Record.class);
			String desc= record.desc();
			System.err.println("befor:"+desc);
			//正则匹配{}
			Pattern pattern = Pattern.compile("(\\{[^\\}]+\\})");
			Matcher matcher = pattern.matcher(desc);
			//处理每一个匹配到的表达式
			while(matcher.find()) {
				String expression= matcher.group(1);//获取第一个正则捕获符匹配到的结果
				String value= "null";//替换值默认为null字符串
				if(expression.startsWith("{session:")) {//会话值 处理
					String name= expression.replace("{session:", "").replace("}", "");
					Collection<Object> attributeKeys= session.getAttributeKeys();//会话属性keys
					if(name.contains(".")) {//是否包含.
						String[] names= name.split("\\.");
						if(attributeKeys.contains(names[0])) {
							//获取session属性对象
							Object obj= session.getAttribute(names[0]);
							if(null!= obj) {
								Class<? extends Object> clazz= obj.getClass();
								for(int i=1; i< names.length; i++) {
									//获取字段对象
									Field field= clazz.getDeclaredField(names[i]);
									clazz= field.getType();//获取字段表示的值类型
									field.setAccessible(true);//禁止java语言访问检查
									obj= field.get(obj);//获取字段表示的值对象
								}
								if(null!= obj) {//双重判断obj，因上面循环中重新赋值了obj
									value= obj.toString();
								}
							}
						}else {
							throw new RuntimeException("找不到匹配的属性:"+names[0]);
						}
					}else {
						if(attributeKeys.contains(name)) {
							Object obj= session.getAttribute(name);
							if(null!= obj) {
								value= obj.toString();
							}
						}else {
							throw new RuntimeException("找不到匹配的属性:"+name);
						}
					}
				}
				if(expression.startsWith("{param:")) {//参数值 处理
					Object[] args= joinPoint.getArgs();//连接点参数值
					String[] parameterNames= methodSignature.getParameterNames();//连接点参数名
					String name= expression.replace("{param:", "").replace("}", "");
					if(name.contains(".")) {
						String[] names= name.split("\\.");
						int index= -1;
						for(int i=0;i<parameterNames.length;i++) {
							if(names[0].equals(parameterNames[i])) {
								index = i;
								break;
							}
						}
						if(index!= -1) {
							Object obj= args[index];
							if(null!= obj) {
								Class<? extends Object> clazz= obj.getClass();
								for(int i=1; i< names.length; i++) {
									Field field= clazz.getDeclaredField(names[i]);
									clazz= field.getType();
									field.setAccessible(true);
									obj= field.get(obj);
								}
								if(null!= obj) {//双重判断obj，因上面循环中重新赋值了obj
									value= obj.toString();
								}
							}
						}else {
							throw new RuntimeException("找不到匹配的参数:"+names[0]);
						}
					}else {
						int index= -1;
						for(int i=0;i<parameterNames.length;i++) {
							if(name.equals(parameterNames[i])) {
								index= i;
								break;
							}
						}
						if(index!= -1) {
							Object obj= args[index];
							if(null!= obj) {
								value= obj.toString();
							}
						}else {
							throw new RuntimeException("找不到匹配的参数:"+name);
						}
					}
				}
				//替换表达式值
				desc= desc.replaceFirst(Pattern.quote(expression),value);
			}
			System.err.println("after:"+desc);
			//保存日志entity
			SysOperateLog sol= new SysOperateLog();
			sol.setLogtime(new Date());
			sol.setLogtype(Short.valueOf(String.valueOf(record.type().ordinal())));
			sol.setOperateType(Short.valueOf(String.valueOf(record.operate().ordinal())));
			sol.setText(desc);
			User user = (User) session.getAttribute("userInfo");
			sol.setUserid(user.getId());
			if(systemOperateLogService.insertSelective(sol)> 0) {
				System.err.println("日志插入成功！！");
			}else {
				System.err.println("日志插入失败！！");
			}
		}else {
			throw new RuntimeException("签名异常:"+ signature.getClass());
		}*/
	}
	
}
