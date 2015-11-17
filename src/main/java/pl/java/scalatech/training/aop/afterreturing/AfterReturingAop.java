package pl.java.scalatech.training.aop.afterreturing;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.training.aop.LogJointpoint;
import pl.java.scalatech.training.bike.Bike;

@Aspect
@Component
@Slf4j
@Profile("afterReturing")
public class AfterReturingAop extends LogJointpoint{
    @Pointcut("execution(* pl..BikeService+.get*(*))")
    private void getMethodAdv(){}



    @AfterReturning(value = "getMethodAdv()  && args(type)",returning="value")
    public void afreturning( JoinPoint joinPoint, String type,Bike value) {
        logJoinPoint(joinPoint);
        log.info("+++  {} : bike : {}","afterreturing",value);

    }
}