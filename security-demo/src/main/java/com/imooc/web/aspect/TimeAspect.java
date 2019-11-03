/**
 * 
 */
package com.imooc.web.aspect;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author zhailiang
 *
 */
//@Aspect
//@Component
//用aop切片是因为拦截器取不到拦截的方法名
public class TimeAspect {
	
	//@Around相当于init、do、destory,
	@Around("execution(* com.imooc.web.controller.UserController.*(..))")
	public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
		
		System.out.println("time aspect start");
		
		Object[] args = pjp.getArgs();
		for (Object arg : args) {
			System.out.println("arg is "+arg);
		}
		
		long start = new Date().getTime();
		
		Object object = pjp.proceed();
		
		System.out.println("time aspect 耗时:"+ (new Date().getTime() - start));
		
		System.out.println("time aspect end");
		
		return object;
	}

}
