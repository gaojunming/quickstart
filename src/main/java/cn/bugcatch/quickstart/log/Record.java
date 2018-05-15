package cn.bugcatch.quickstart.log;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 日志注解：配合aop实现自动记录
 * 注意：插入一个实体到数据库时如果需要记录实体id，注意回填实体的id
 * @author gao
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Record {
	/**
	 * 日志描述
	 * 支持简单表达式：{session:xx}或{param:xx}来实现动态插入变量
	 * session:表示从session获取属性
	 * param:表示从当前方法参数中获取参数
	 * 支持.操作符:user.name
	 * 例子：{session:userInfo.username}
	 * @return
	 */
	public String desc();
	/**
	 * 日志类型
	 * @return
	 */
	public Type type();
	/**
	 * 操作类型
	 * @return
	 */
	public Operate operate() default Operate.NORMAL;
	
	public enum Type{//此枚举的元素可根据需要进行扩展
		LOGIN,//登陆
		LOGINOUT,//退出
		RECORD//录音信息
	}
	public enum Operate{
		INSERT,//增加
		DELETE,//删除
		UPDATE,//更新
		SELECT,//查看
		NORMAL//非curd日志
	}
}
