package com.ronaldqinbiao.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ronaldqinbiao.entity.Student;
import com.ronaldqinbiao.repository.StudentRepository;

@RestController
@RequestMapping("/student")
public class StudentHandler {

	@Autowired
	private StudentRepository studentRepository;
	
	@Value("${server.port}")
	private String port;

	@GetMapping("/findAll")
	public Collection<Student> findAll() {
		return studentRepository.findAll();
	}

	@GetMapping("/findById/{id}")
	public Student findById(@PathVariable("id") long id) {
		return studentRepository.findById(id);
	}

	@PostMapping("/save")
	public void save(@RequestBody Student student) {
		studentRepository.saveOrUpdate(student);
	}

	@PutMapping("/update")
	public void update(@RequestBody Student student) {
		studentRepository.saveOrUpdate(student);
	}

	@DeleteMapping("/deleteById/{id}")
	public void deleteById(@PathVariable("id") long id) {
		studentRepository.deleteById(id);
	}
	
	@GetMapping("/index")
	public String index() {
		return "当前端口：" + this.port;
	}
}
