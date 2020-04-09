package com.stefan.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: ${todo}
 * @Author: Stefan
 * @Date: 2020/4/8 10:11 AM
 */
@Aspect
@Component
public class TimerAspect {

    /** 切点：execution表达式配置 */
    @Pointcut("execution(public * com.stefan.controller..*.*(..))")
    public void logPointCut() { }

    /** 前置增强 */
    @Before("logPointCut()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        System.out.println("so before------");
    }

    /** 后置增强 */
    @After("logPointCut()")
    public void doAfter() {
        System.out.println("do after------");
    }

    /** 最终增强 */
    @AfterReturning("logPointCut()")
    public void doFinally() {
        System.out.println("do finally-------");
    }

    /** 环绕增强 */
    @Around("logPointCut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("do around start------");
        Object result = pjp.proceed();
        System.out.println("do around end--------");
        return result;
    }

}
