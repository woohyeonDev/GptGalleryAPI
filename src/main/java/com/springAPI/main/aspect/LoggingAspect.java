package com.springAPI.main.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.springAPI.main.controller.UserController..*.*(..))")  // Adjust this expression as needed
    public void beforeMethod(JoinPoint joinPoint) {
        logger.info("Entering method: " + joinPoint.getSignature().getName());
    }

    @After("execution(* com.springAPI.main.controller.UserController..*.*(..))")  // Adjust this expression as needed
    public void afterMethod(JoinPoint joinPoint) {
        logger.info("Exiting method: " + joinPoint.getSignature().getName());
    }
}
