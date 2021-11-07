package com.hoaipx.learn2021.common.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.hoaipx.learn2021.common.Constant;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Pointcut(value = Constant.EXECUTIONS)
    public void loggingPointCut() {
    }

    @Around("loggingPointCut()")
    public Object loggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        String methodName = proceedingJoinPoint.getSignature().getName();
        String className = proceedingJoinPoint.getTarget().getClass().toString();

        Object[] array = proceedingJoinPoint.getArgs();
        log.info("Inside " + className + " class: " + methodName + " method, with request: " + mapper.writeValueAsString(array));

        Object response = proceedingJoinPoint.proceed();
        log.info("Inside " + className + " class: " + methodName + " method, with response: " + mapper.writeValueAsString(response));
        return response;
    }

}
