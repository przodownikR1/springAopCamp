package pl.java.scalatech.training.aop.caseaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.training.aop.Check;
import pl.java.scalatech.training.aop.LogJointpoint;
@Aspect
@Component
@Slf4j
@Profile("check")
public class BeforeCheckAop extends LogJointpoint {
    @Pointcut("@annotation(check)")
    private void check() {}
    
    
    @Before(value="@annotation(check)")
     public void before(JoinPoint joinPoint,Check check) {
         logJoinPoint(joinPoint);
         log.info("+++ logText :  {}",check.logText());
     }
     
}
