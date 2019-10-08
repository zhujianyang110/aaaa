package chapter3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import chapter3.entity.User;

@Controller
public class IndexController {
	
	@RequestMapping("/hello1")
	public String hello(@RequestParam(defaultValue="world",required=false)String name,Model model){
		model.addAttribute("name",name);
		return "index";
	}
	
	@GetMapping("/aboutMe")
	public String index(Model model){
		User user = new User();
		user.setUsername("yukong");
		user.setPassword("abc123");
		user.setAge(18);
		user.setSex(1);
		model.addAttribute("user",user);
		return "aboutMe";
	}
	
}
