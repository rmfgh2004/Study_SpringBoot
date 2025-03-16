package com.example.filter.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.example.filter.model.UserRequest;

@Aspect
@Component
public class TimerAop {

    @Pointcut(value = "within(com.example.filter.controller.UserApiController)")
    public void timerPointCut() {}

    @Before(value = "timePointCut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("before");
    }

    @After(value = "timePointCut()")
    public void after(JoinPoint joinPoint) {
        System.out.println("after");
    }

    @AfterReturning(value = "timePointCut()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("AfterReturning");
    }

    @AfterThrowing(value = "timePointCut()", throwing = "tx")
    public void afterThrowing(JoinPoint joinPoint, Throwable tx) {
        System.out.println("AfterThrowing");
    }


    @Around(value = "timerPointCut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("메소드 실행 이전");
        
        Arrays.stream(joinPoint.getArgs()).forEach(it -> {
            if (it instanceof UserRequest) {
                var tempUser = (UserRequest) it;
                tempUser.setPhoneNumber(tempUser.getPhoneNumber().replaceAll("-", ""));
            }
        });

        joinPoint.proceed();

        System.out.println("메소드 실행 이후");
    }
    
}
