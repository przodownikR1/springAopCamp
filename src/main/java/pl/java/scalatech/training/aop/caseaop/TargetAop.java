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
    
    //TODO
    @Pointcut("execution( *  pl.java.scalatech.training.bike.BikeService.*(..)) && target(target)")
    public void somePointcut(Object target) {
    }
    
    @Before("somePointcut(target)")
    public void beforeTarget(JoinPoint joinPoint,Object target) {
        logJoinPoint(joinPoint);
      
    }
}
