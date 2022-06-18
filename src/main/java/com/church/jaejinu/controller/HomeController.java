package com.church.jaejinu.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Locale locale, Model model) {
	
	return "redirect:/login";
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Locale locale, Model model) {
		Logger.info("Welcome home! The Client localeis {}.",locale);
		System.out.println("test() 메소드 실행");
		LocalDateTime now = LocalDateTime.now();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 M월 d일 (E) a h시 m분 s초");
		String formattedNow = now.format(formatter);
		model.addAttribute(formattedNow, "serverTime");
		model.addAttribute("serverTime",formattedNow);
		
		Logger.debug(formattedNow);
		
		System.out.println(formattedNow+"asdfasdf");
		
		return "/index";
	}
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	    public String hello(){
	        return "hello";
	    }
	
}
