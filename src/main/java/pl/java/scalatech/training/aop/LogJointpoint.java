package pl.java.scalatech.training.aop;

import org.aspectj.lang.JoinPoint;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class LogJointpoint {
    protected void logJoinPoint(JoinPoint joinPoint) {
        log.info("getArgs:  {}",joinPoint.getArgs());
/*        log.info("target:  {}",joinPoint.getTarget());
        log.info("class:  {}",joinPoint.getClass());
        log.info("signature:  {}",joinPoint.getSignature());
        log.info("signature :declarationType:  {}",joinPoint.getSignature().getDeclaringType());
        log.info("signature :declarationTypeName:  {}",joinPoint.getSignature().getDeclaringTypeName());*/
        log.info("signature :name:  {}",joinPoint.getSignature().getName());
        log.info("getArgs:  {}",joinPoint.getArgs());
    }
}
