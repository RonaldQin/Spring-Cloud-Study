package com.ronaldqinbiao.feign.impl;

import java.util.Collection;

import org.springframework.stereotype.Component;

import com.ronaldqinbiao.entity.Student;
import com.ronaldqinbiao.feign.FeignProviderClient;

@Component
public class FeignError implements FeignProviderClient {

	@Override
	public Collection<Student> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String index() {
		return "服务器维护中...";
	}

}
