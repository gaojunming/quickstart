package cn.bugcatch.quickstart.user.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import cn.bugcatch.quickstart.core.DateJsonDeserializer;

public class XmlTestPojo {
	public String name="gaojunming";
	public Integer age=25;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date date;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "XmlTestPojo [name=" + name + ", age=" + age + ", date=" + date + "]";
	}
	
}
