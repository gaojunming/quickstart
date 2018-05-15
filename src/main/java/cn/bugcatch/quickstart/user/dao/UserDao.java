package cn.bugcatch.quickstart.user.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

//@Mapper
public interface  UserDao {
	@Select("SELECT * FROM sec_user WHERE id = #{id}")
    Map<String,Object> find(@Param("id") Long id);
	@Select("SELECT * FROM sec_user WHERE id = #{id}")
	@Update("update sec_user set username='aaa' where id= #{id}")
    int update1(@Param("id") Long id);
	@Update("update sec_user set username='bbb' where id= #{id}")
    int update(@Param("id") Long id);
}
