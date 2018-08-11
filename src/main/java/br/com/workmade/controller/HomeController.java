package br.com.workmade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	
	@GetMapping("/demo-mvc")
	public String home() {
		return "/home";
	}

}
