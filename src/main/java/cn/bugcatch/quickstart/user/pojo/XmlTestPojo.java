package cn.bugcatch.quickstart.user.pojo;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import cn.bugcatch.quickstart.core.DateJsonDeserializer;

public class XmlTestPojo {
	public String name="gaojunming";
	public Integer age=25;
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
