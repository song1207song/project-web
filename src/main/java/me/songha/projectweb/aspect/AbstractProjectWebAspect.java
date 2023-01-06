package me.songha.projectweb.aspect;

import me.songha.projectweb.service.ProjectWebService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * @Description :: @Logging 어노테이션의 실제 동작을 구현한 aspect 구현체이다.
 * 동작한 클래스명, 메소드명과 소요 시간, 파라미터를 로그로 남긴다.
 */
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

        Object returnValue = null;
        try {
            returnValue = joinPoint.proceed();
        } catch (Exception e) {
            log.error("Unexpected error has occurred. :: errorMessage->{}", e.getMessage(), e);
        }

        long end = System.currentTimeMillis();
        long durationTime = end - begin;

        log.info("{}.{} :: duration of time->{}", activeClassName, methodName, durationTime);

        return returnValue;
    }

}
