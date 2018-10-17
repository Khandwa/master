package com.tsys.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class Service2 {
	@RequestMapping(path = "service2", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod="backup")
	public String primary() {
		//when this service failed it will got backup method
		return "actual plan";
	}

	public String backup() {
		//this is backup method when primary fail
		return "backup plan";
	}
}
