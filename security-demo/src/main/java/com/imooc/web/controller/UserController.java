package com.imooc.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.dto.User;
import com.imooc.dto.UserQueryCondition;
import com.imooc.exception.UserNotExistException;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/user")
public class UserController {

	//用户创建请求
	@PostMapping
	public User create(@Valid @RequestBody User user){
		
		/*if(errors.hasErrors()){
			errors.getAllErrors().stream().forEach(error->System.out.println(error.getDefaultMessage()));
		}*/
		
		System.out.println(user.getId());
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getBirthday());
		
		user.setId("1");
		return user;
	}
	
	//用户更新请求
	@PutMapping("/{id:\\d+}")
	public User update(@Valid @RequestBody User user,BindingResult errors){
		//验证后报错的信息
		if(errors.hasErrors()){
			errors.getAllErrors().stream().forEach(error->{
				/*FieldError fieldError = (FieldError) error;
				String message = fieldError.getField() + error.getDefaultMessage();
				System.out.println(message);*/
				System.out.println(error.getDefaultMessage());
			}
			);
		}
		
		System.out.println(user.getId());
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getBirthday());
		
		user.setId("1");
		return user;
	}
	
	//用户删除请求
	@DeleteMapping("/{id:\\d+}")
	public void delete(@PathVariable String id) {
		System.out.println(id);
	}
	
	//用户查询请求
	@GetMapping
	//@PageableDefault指定分页参数默认值
	@JsonView(User.UserSimpleView.class)
	@ApiOperation(value="用户查询服务")
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
	
	//根据id用户查询请求
	@GetMapping("/{id:\\d+}")
	@JsonView(User.UserDetailView.class)
	public User getInfo(@ApiParam(value="用户id") @PathVariable String id){
//		throw new RuntimeException(id);
//		throw new UserNotExistException(id);
		
		System.out.println("进入getinfo服务");
		User user = new User();
		user.setUsername("tom");
		return user;
	}
}
