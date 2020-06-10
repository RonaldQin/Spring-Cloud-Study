package com.example.feign;

import java.util.Collection;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.entity.Student;

@FeignClient(value = "provider")
public interface FeignProviderClient {
	@GetMapping("/student/findAll")
	public Collection<Student> findAll();

	@GetMapping("/student/index")
	public String index();
}
