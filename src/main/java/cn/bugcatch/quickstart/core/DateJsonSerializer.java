package cn.bugcatch.quickstart.core;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
/**
 * 把java日期类型序列化到json日期类型（响应时）
 * 应在响应类型为json时使用
 * @author gao
 *
 */
@JsonComponent//如果不注册为jsoncomponent需要手动跟字段绑定@JsonSerialize(using=DateJsonSerializer.class)
public class DateJsonSerializer extends JsonSerializer<Date> {
	public static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
			throws IOException, JsonProcessingException {
		jsonGenerator.writeString(format.format(date));
	}
}