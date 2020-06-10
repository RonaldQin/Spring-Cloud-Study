package com.example.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;
import com.example.feign.FeignProviderClient;

@RestController
@RequestMapping("/hystrix")
public class HystrixHandler {

	@Autowired
	private FeignProviderClient feignProviderClient;

	@GetMapping("/findAll")
	public Collection<Student> findAll() {
		return feignProviderClient.findAll();
	}

	@GetMapping("/index")
	public String index() {
		return feignProviderClient.index();
	}
}
