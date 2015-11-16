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
@Profile("getMethod")
public class BeforeAopSelectMethod extends LogJointpoint{
    @Pointcut("execution(* pl..BikeService+.get*())")   //() //.. //* 
    private void getMethod(){}
    
  
    
   @Before("getMethod()")
    public void beforeGet(JoinPoint joinPoint) {
        logJoinPoint(joinPoint);
      
    }
}
