package com.douzone.hellospring.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @RequesgtMapping url+ request 메소드 매핑 
 *
 */

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "/WEB-INF/views/join.jsp";
	}

	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(String name, String email, String password, String gender) throws UnsupportedEncodingException {
		
		System.out.println(name+email+password+gender);
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public String update(@RequestParam("n") String name) {
		/**
		 * 만일 n이라는 이름의 파라미터가 없는 경우 400 Bad Request 에러가 발생한다. 
		 * 
		 */
		return "UserController.update(" + name  + ")";
	}
	
	@ResponseBody
	@RequestMapping("/update2")
	public String update2(@RequestParam(value="n", required = true, defaultValue="") String name) {
		/**
		 * 만일 n이라는 이름의 파라미터가 없는 경우 400 Bad Request 에러가 발생한다. 
		 * 
		 */
		return "UserController.update(" + name  + ")";
	}
	
	
}
