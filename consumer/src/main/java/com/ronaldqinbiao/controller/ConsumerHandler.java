package com.ronaldqinbiao.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ronaldqinbiao.entity.Student;

@RestController
@RequestMapping("/consumer")
public class ConsumerHandler {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/findAll")
	public Collection<Student> findAll() {
		return restTemplate.getForEntity("http://192.168.161.132:8010/student/findAll", Collection.class).getBody();
	}

	@GetMapping("/findAll2")
	public Collection<Student> findAll2() {
		return restTemplate.getForObject("http://192.168.161.132:8010/student/findAll", Collection.class);
	}

	@GetMapping("/findById/{id}")
	public Student findById(@PathVariable("id") long id) {
		return restTemplate.getForEntity("http://192.168.161.132:8010/student/findById/{id}", Student.class).getBody();
	}

	@GetMapping("/findById2/{id}")
	public Student findById2(@PathVariable("id") long id) {
		return restTemplate.getForObject("http://192.168.161.132:8010/student/findById/{id}", Student.class);
	}

	@PostMapping("/save")
	public void save(@RequestBody Student student) {
		restTemplate.postForEntity("http://192.168.161.132:8010/student/save", student, null);
	}

	@PostMapping("/save2")
	public void save2(@RequestBody Student student) {
		restTemplate.postForObject("http://192.168.161.132:8010/student/save", student, null);
	}

	@PutMapping("/update")
	public void update(@RequestBody Student student) {
		restTemplate.put("http://192.168.161.132:8010/student/update", student);
	}

	@DeleteMapping("/deleteById/{id}")
	public void deleteById(@PathVariable("id") long id) {
		restTemplate.delete("http://192.168.161.132:8010/student/deleteById/{id}", id);
	}
}
