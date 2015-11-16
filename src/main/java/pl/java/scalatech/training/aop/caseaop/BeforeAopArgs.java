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
@Profile("args")
public class BeforeAopArgs extends LogJointpoint{
    @Pointcut("args(String)")
    private void args(){}
    
    @Before("args()")
    public void beforeTyres(JoinPoint joinPoint) {
        logJoinPoint(joinPoint);
      
    }
    
    
}
