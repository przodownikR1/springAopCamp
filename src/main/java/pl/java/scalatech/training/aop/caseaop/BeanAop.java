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
@Profile("bean")
public class BeanAop extends LogJointpoint{

   
    
    @Before("bean(*pl.java.scalatech.training.bike.impl.BikeServiceImpl)")
    public void log(JoinPoint joinPoint) {
        logJoinPoint(joinPoint);
    }
}
