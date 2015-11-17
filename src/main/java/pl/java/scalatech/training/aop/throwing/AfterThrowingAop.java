package pl.java.scalatech.training.aop.throwing;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Profile("throwing")
@Slf4j
public class AfterThrowingAop {
    //@Pointcut("execution( *  pl.java.scalatech.training.bike.BikeService.thTest(..))")
    //@Around("execution (@annotation.Trace * *(..))")
    @Pointcut("within(pl.java.scalatech.training.bike.BikeService+)")
    //@Pointcut("execution(* th*(..))")
    private void serviceExLog() {}


    @AfterThrowing(pointcut = "serviceExLog()", throwing = "ex")
    public Object logAfterThrowing(JoinPoint joinPoint, Throwable ex) {

        log.info("++++++  {} , ex : {} ",joinPoint.getArgs()[0],ex);
        return ex;

    }
}