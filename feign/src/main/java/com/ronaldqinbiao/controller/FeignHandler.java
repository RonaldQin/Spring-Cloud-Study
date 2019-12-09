package com.ronaldqinbiao.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ronaldqinbiao.entity.Student;
import com.ronaldqinbiao.feign.FeignProviderClient;

@RestController
@RequestMapping("/feign")
public class FeignHandler {

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
