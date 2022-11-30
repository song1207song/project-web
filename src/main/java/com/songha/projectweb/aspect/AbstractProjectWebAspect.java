package com.songha.projectweb.aspect;

import com.songha.projectweb.service.ProjectWebService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

@Slf4j
public abstract class AbstractProjectWebAspect {
    protected ProjectWebService projectWebService;
    protected abstract void setProjectWebService(ProjectWebService projectWebService);

    protected abstract void setCategoryPointCut();

    @Around("@annotation(LoggingPerformance)")
    public Object logPerformance(ProceedingJoinPoint pjp) throws Throwable {
        long begin = System.currentTimeMillis();

        Object returnValue = pjp.proceed();

        long end = System.currentTimeMillis();

        long durationTime = end - begin;

        log.info("AbstractProjectWebAspect.logPerf :: duration of time->{}", durationTime);

        return returnValue;
    }

}
