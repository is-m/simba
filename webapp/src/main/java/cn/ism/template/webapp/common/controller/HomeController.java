package cn.ism.template.webapp.common.controller;
 

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class HomeController {
 
	@RequestMapping("/")
	public String homePage(){  
		return "redirect:/web/index.html"; 
	}
	
	@RequestMapping("/web/")
	public String webPage(){  
		return "/web/index.html"; 
	}
}
