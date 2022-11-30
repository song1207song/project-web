package com.songha.projectweb.aspect;

import com.songha.projectweb.annotation.Logging;
import com.songha.projectweb.service.ProjectWebService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

@Slf4j
public abstract class AbstractProjectWebAspect {
    protected ProjectWebService projectWebService;

    protected abstract void setProjectWebService(ProjectWebService projectWebService);

    protected abstract void categoryPointCut();

    @Around("@annotation(com.songha.projectweb.annotation.Logging)")
    public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
        Class<?> activeClass = joinPoint.getTarget().getClass();
//        logging = activeClass.getAnnotation(Logging.class);
        String activeClassName = activeClass.getName();

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        String methodName = method.getName();

        long begin = System.currentTimeMillis();
        Object returnValue = joinPoint.proceed();
        long end = System.currentTimeMillis();
        long durationTime = end - begin;

        log.info("{}.{} :: duration of time->{}", activeClassName, methodName, durationTime);

        return returnValue;
    }

}
