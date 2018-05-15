package cn.bugcatch.quickstart.user.controller;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import cn.bugcatch.quickstart.user.pojo.XmlTestPojo;
import cn.bugcatch.quickstart.user.service.UserService;

@RestController
@RequestMapping(value="/users")
public class UserRestController {
	@Autowired
	private UserService userService;
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Object getUser(@PathVariable Long id) {
		Object o= userService.update(id);
		System.out.println(o);
		return o;
	}
	@RequestMapping(value="/ttt", method=RequestMethod.PATCH)
	public void ttt(XmlTestPojo vvv) {//Long[] vvv) {//@RequestBody XmlTestPojo vvv
		System.err.println(vvv);
	}
	//@RequestMapping(value="/{user}", method=RequestMethod.DELETE)
	//public User deleteUser(@PathVariable Long user) {
	// ...
	//}
}
