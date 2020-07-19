package com.myRestService.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.myRestService.bean.HelloWorldBean;

@RestController
public class HelloWorldController {

	@GetMapping("/hello/{name}")
	public HelloWorldBean getHelloString(@PathVariable String name) {
		return new HelloWorldBean("Hello "+ name+"... Good Morning");
	}
}
