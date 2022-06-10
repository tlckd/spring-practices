package com.douzone.aoptest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	
	@Before("execution(public com.douzone.aoptest.vo.ProductVo com.douzone.aoptest.service.ProductService.find(String))") 
	public void beforeAdvice() {
		System.out.println("--- Before Advice---");
	}
	
	@After("execution(* *..*.ProductService.find(String))") 
	public void afterAdvice() {
		System.out.println("--- After Advice---");
	}
	
	@AfterReturning ("execution(* *..*.ProductService.*(..))") 
	public void afterReturningAdvice() {
		System.out.println("--- @AfterReturning Advice---");
	}
	
	@AfterThrowing (value="execution(* *..*.*.*(..))" , throwing="ex") 
	public void afterAfterThrowingAdvice(Throwable ex) {
		System.out.println("--- AfterThrowing Advice---");
	}
	
	@Around("execution(* *..*.ProductService.*(..))")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		
		// 비포 어드바이스
		System.out.println("--- 어라운드(비포) Advice---");
		
		
		//포인트컷 메소드 실행  
		//Object result = pjp.proceed();
		
		// 포인트컷 메소드 파라미터 바꿔치기
		Object[] params = {"Camera"};
		Object result = pjp.proceed(params);
		
		// 에프터 어드바이스
		System.out.println("--- 어라운드(에프터) Advice---");
		return result;
		
	}
	
}
