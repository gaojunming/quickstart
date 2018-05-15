package cn.bugcatch.quickstart.user.service;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.bugcatch.quickstart.log.Record;
import cn.bugcatch.quickstart.user.dao.UserDao;
@Component
public class UserService {
	@Autowired
	private UserDao userDao;
	//@Transactional
	@Record(desc="aaa",operate=Record.Operate.DELETE,type=Record.Type.LOGIN)
	public Map<String,Object> update(Long id){
		userDao.update(id);
		if(true)
			throw new RuntimeException();
		return userDao.find(id);
	}
}
