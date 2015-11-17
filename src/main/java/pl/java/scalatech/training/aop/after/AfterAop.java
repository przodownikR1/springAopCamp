package pl.java.scalatech.training.aop.after;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.training.aop.LogJointpoint;

@Aspect
@Component
@Slf4j
@Profile("after")
public class AfterAop extends LogJointpoint{

    @Pointcut("execution(* pl..BikeService+.get*(*))")
    private void getMethodAdv(){}



    @AfterReturning(value = "getMethodAdv()  && args(type)")
    public void after( JoinPoint joinPoint, String type) {
        logJoinPoint(joinPoint);
        log.info("+++  {} : bike : {}","after");

    }
}