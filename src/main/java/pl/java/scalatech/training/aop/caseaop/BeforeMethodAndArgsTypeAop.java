package pl.java.scalatech.training.aop.caseaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.training.aop.LogJointpoint;
import pl.java.scalatech.training.bike.Bike;
@Aspect
@Component
@Slf4j
@Profile("methodArgsType")
public class BeforeMethodAndArgsTypeAop extends LogJointpoint{

    @Pointcut("execution(* pl..BikeService+.get*(*))")  
    private void getMethodAdv(){}
    
    @Before("getMethodAdv() && args(type)")
    public void beforeAdv(JoinPoint joinPoint, String type){
        logJoinPoint(joinPoint);
        log.info("+++ type : {}",type);
        
    }
}
