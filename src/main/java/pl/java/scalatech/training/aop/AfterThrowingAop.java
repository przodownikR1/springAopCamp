package pl.java.scalatech.training.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
//@Component
@Slf4j
public class AfterThrowingAop {

    @Pointcut("@annotation(pl.java.scalatech.annotation.CatchException) || within(@org.springframework.stereotype.Service *) ")
    private void serviceExLog() {}


    @AfterThrowing(pointcut = "serviceExLog()", throwing = "ex")
    public Object logAfterThrowing(JoinPoint joinPoint, Throwable ex) {

        log.info("+++  {}","test");
        return ex;

    }
}