package chapter3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chapter3.entity.User;
import chapter3.service.UserService;


@RestController
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public User save(@RequestBody User user){
		return userService.saveUser(user);
	}
	
	@PutMapping
	public User update(@RequestBody User user){
		return userService.saveUser(user);
	}
	
	@DeleteMapping(value="/id/{id}")
	public String delete(@PathVariable Long id){
		userService.deleteById(id);
		return "删除成功";
	}
	
	@GetMapping(value = "/id/{id}")
	public User findById(@PathVariable Long id){
		return userService.getById(id);
	}
	
	@GetMapping(value = "/username/{username}")
	public User findByUsername(@PathVariable String username){
		return userService.getByUserName(username);
	}
	
	@GetMapping(value="/")
	public List<User> findAll(){
		return userService.queryAll();
	}
}


