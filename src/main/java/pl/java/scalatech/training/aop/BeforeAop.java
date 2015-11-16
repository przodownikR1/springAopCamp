package pl.java.scalatech.training.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
@Aspect
@Component
@Slf4j
public class BeforeAop {

    @Pointcut("@annotation(check)")
    private void check() {}

    @Before(value="@annotation(check)")
    public void before(JoinPoint joinPoint,Check check) {
        log.info("getArgs:  {}",joinPoint.getArgs());
        log.info("target:  {}",joinPoint.getTarget());
        log.info("class:  {}",joinPoint.getClass());
        log.info("signature:  {}",joinPoint.getSignature());
        log.info("signature :declarationType:  {}",joinPoint.getSignature().getDeclaringType());
        log.info("signature :declarationTypeName:  {}",joinPoint.getSignature().getDeclaringTypeName());
        log.info("signature :name:  {}",joinPoint.getSignature().getName());
        log.info("getArgs:  {}",joinPoint.getArgs());
        
        log.info("+++  {}",check.logText());

    }
}  