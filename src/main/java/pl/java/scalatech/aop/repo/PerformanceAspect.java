package pl.java.scalatech.aop.repo;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.google.common.base.Stopwatch;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
@Profile("measure")
public class PerformanceAspect {
    @PostConstruct
    public void init(){
        log.info("++++ measure component Aspect ...");
    }
    
    @Pointcut("within(@org.springframework.stereotype.Repository *)")
    public void repositoryClassMethods() {};

    @Around("repositoryClassMethods()")
    public Object measureMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("ASDDDDDDDDDDDDDDDDDDDDDDDDDDD");
        final Stopwatch stopwatch = Stopwatch.createStarted();
        Object returnValue = joinPoint.proceed();

        String methodName = joinPoint.getSignature().getName();
        stopwatch.stop();

        log.info("Method : {} => elapsed time in Nanoseconds {} ", methodName, stopwatch.elapsed(TimeUnit.NANOSECONDS));
        return returnValue;
    }
}