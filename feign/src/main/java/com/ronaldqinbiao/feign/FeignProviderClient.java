package com.ronaldqinbiao.feign;

import java.util.Collection;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.ronaldqinbiao.entity.Student;
import com.ronaldqinbiao.feign.impl.FeignError;

@FeignClient(value = "provider", fallback = FeignError.class)
public interface FeignProviderClient {
	@GetMapping("/student/findAll")
	public Collection<Student> findAll();

	@GetMapping("/student/index")
	public String index();
}
