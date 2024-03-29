package com.douzone.emaillist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.douzone.emaillist.repository.EmaillistRepository;
import com.douzone.emaillist.vo.EmaillistVo;

@Controller
public class EmaillistController {
	@Autowired
	private EmaillistRepository emailRepository;
	
	@RequestMapping("")
	public String index(Model model) {
		List<EmaillistVo> list =emailRepository.findAll();
		model.addAttribute("list",list);
		
		return "/WEB-INF/views/index.jsp";
	}
	
	@RequestMapping("/form")
	public String form() {
		return "/WEB-INF/views/form.jsp";
	}
	
	@ResponseBody
	@RequestMapping(value="/add" , method=RequestMethod.POST)
	public String form(EmaillistVo vo) {
		System.out.println(vo);
		emailRepository.insert(vo);
		return "redirect:/";
	}
	
	
}


