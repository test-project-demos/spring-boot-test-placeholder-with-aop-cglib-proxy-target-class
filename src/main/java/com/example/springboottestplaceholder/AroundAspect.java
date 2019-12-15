package com.example.springboottestplaceholder;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author zhixiao.mzx
 * @date 2019/12/14
 */
@Slf4j
@Aspect
@Component
public class AroundAspect {
    @Around("execution(* com.example.springboottestplaceholder.TestProxyByCglib.testAop())")
    public Object aroundTestAop(ProceedingJoinPoint joinPoint) throws Throwable {
        return joinPoint.proceed();
    }
}
