package cn.bugcatch.quickstart.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.bugcatch.quickstart.log.Record;
import cn.bugcatch.quickstart.user.dao.UserDao;
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
	//@RequestMapping(value="/{user}/customers", method=RequestMethod.GET)
	//List<Customer> getUserCustomers(@PathVariable Long user) {
	// ...
	//}
	//@RequestMapping(value="/{user}", method=RequestMethod.DELETE)
	//public User deleteUser(@PathVariable Long user) {
	// ...
	//}
}
