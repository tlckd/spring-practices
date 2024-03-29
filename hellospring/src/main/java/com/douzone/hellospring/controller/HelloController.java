package com.douzone.hellospring.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Controller
public class HelloController {
	@RequestMapping("/hello") 
	public String hello() {
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello2") 
	public String hello2(String name) {
		System.out.println(name);
		return "/WEB-INF/views/hello2.jsp";
	}
	
	@RequestMapping("/hello3") 
	public ModelAndView hello3(String name) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name",name);
		mav.setViewName("/WEB-INF/views/hello3.jsp");
		return mav;
	}
	
	@RequestMapping("/hello4") 
	public String hello4(String name, Model model) {
		model.addAttribute("name",name);
		return "/WEB-INF/views/hello4.jsp";
	}
	
	@ResponseBody
	@RequestMapping("/hello5") 
	public String hello5() {
		return "<h1>hello World</h1>";
	}
	
	
	@RequestMapping("/hello6") 
	public String hello6() {
		return "redirect:/hello";
	}
	
	@RequestMapping("/hello7") 
	public void hello7(HttpServletRequest request, HttpServletResponse response, HttpSession session, Writer pw) throws IOException {
		pw.write(""); //비추 기술비침투 전략 위배

	}
	
}