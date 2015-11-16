package pl.java.scalatech.training.aop.caseaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.training.aop.LogJointpoint;
@Aspect
@Component
@Slf4j
@Profile("target")
public class TargetAop extends LogJointpoint{
    
    @Pointcut("target(pl.java.scalatech.training.bike.BikeService)")
    public void somePointcut() {
    }
       
    @Before("somePointcut()")
    public void beforeTarget(JoinPoint joinPoint) {
        logJoinPoint(joinPoint);
      
    }
    
    @Pointcut("@target(pl.java.scalatech.annotation.AopClass)")
    public void somePointcutAd() {
    }
    
    @Before("somePointcutAd()")
    public void beforeTargetAd(JoinPoint joinPoint) {
        logJoinPoint(joinPoint);
      
    }
    
}
