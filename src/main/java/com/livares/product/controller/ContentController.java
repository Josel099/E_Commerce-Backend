package com.livares.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentController {

	@GetMapping("/home")
	public String handleWelcome() {
		return "welcome home";
	}
	
	@GetMapping("/admin/home")
	public String handleAdminHome() {
		return "home admin";
	}
	
		@GetMapping("/user/home")
	public String handleUserHome() {
		return "user Home";
	}
	
		@GetMapping("/user/welcome")
		public String handleUserWelcom() {
			return "user logined";
		}
		
		@GetMapping("/admin/welcome")
		public String handleAdminWelcome() {
			return "Admin logined";
		}
}
