package com.example.tiendaConcesionario.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

	@GetMapping({"/","/login"})
	public String index(){
		return "index";
	}
	
	@GetMapping({"/menu"})
	public String menu(){
		return "menu";
	}
	
	@GetMapping({"/user"})
	public String user(){
		return "user";
	}
	
	@GetMapping({"/admin"})
	public String admin(){
		return "admin";
	}
	
	@GetMapping({"/logout"})
	public String logout(){
		return "logout";
	}
	
	@RequestMapping("/validador")
	public String validador(HttpServletRequest req, HttpServletRequest resp) {
		
		String usuario = req.getParameter("usuario");
		String password = req.getParameter("password");	
		
		
		if(usuario.equals("admin") && password.equals("12345")) {
			return "menu";
		}else {			
			return "index";
		}
		
	}
	
	
}
