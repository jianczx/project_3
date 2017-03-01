package com.yc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class HelloWorldController {

	//访问了main.jsp
	@RequestMapping("/main.action")
	public String ToMain() {
		return "main";
	}
}
