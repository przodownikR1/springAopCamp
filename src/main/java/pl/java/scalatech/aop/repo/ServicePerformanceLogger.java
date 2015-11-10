package pl.java.scalatech.aop.repo;

import java.util.concurrent.TimeUnit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.google.common.base.Stopwatch;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class ServicePerformanceLogger {
	
	
   
    @Pointcut("execution(public * pl.java.scalatech.repository.*.*(..))")
    public void serviceLog() {}
    
    @Around("serviceLog()")
    public Object measureMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        final Stopwatch stopwatch = Stopwatch.createStarted();
        Object returnValue = joinPoint.proceed();

        String methodName = joinPoint.getSignature().getName();
        stopwatch.stop();

        log.info("Method serviceLog() : {} => elapsed time in MILISEC {} ", methodName, stopwatch.elapsed(TimeUnit.MILLISECONDS));
        return returnValue;
    }


}