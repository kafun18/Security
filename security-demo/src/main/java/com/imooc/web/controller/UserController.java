package com.imooc.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import com.imooc.dto.User;
import com.imooc.dto.UserQueryCondition;

@RestController
public class UserController {

	//@PageableDefault指定分页参数默认值
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public List<User> query(UserQueryCondition condition,
			@PageableDefault(page=2,size=17,sort="username,asc") Pageable pageable) {
		System.out.println(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));
		
		System.out.println(pageable.getPageSize());
		System.out.println(pageable.getPageNumber());
		System.out.println(pageable.getSort());
		List<User> users = new ArrayList<>();
		users.add(new User());
		users.add(new User());
		users.add(new User());
		return users;
	}
	
	@RequestMapping(value="/user/{id:\\d+}",method = RequestMethod.GET)
	public User getInfo(@PathVariable String id){
		User user = new User();
		user.setUsername("tom");
		return user;
	}
}
