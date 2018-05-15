package cn.bugcatch.quickstart.user.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class MyEntity {
	private final JdbcTemplate jdbcTemplate;
	@Autowired
	public MyEntity(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public void query() {
		String sql = "select * from tb_user";
		System.err.println(jdbcTemplate.queryForList(sql));
	}
}
