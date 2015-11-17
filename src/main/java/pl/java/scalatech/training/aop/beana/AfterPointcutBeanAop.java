package pl.java.scalatech.training.aop.beana;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.training.aop.LogJointpoint;

@Aspect
@Component
@Slf4j
@Profile("beana")
public class AfterPointcutBeanAop extends LogJointpoint{

    @Pointcut("bean(*Service)")
    private void bean(){}



    @After("bean()")
    public void after( JoinPoint joinPoint) {
        logJoinPoint(joinPoint);
        log.info("+++  {} : bike : {}","after");

    }
    @Around("bean(*Service)")
    public void trace(ProceedingJoinPoint proceedingJP) throws Throwable {
        String methodInformation = proceedingJP.getStaticPart().getSignature()
                .toString();
        log.info("Entering :" + methodInformation);


        try {
            proceedingJP.proceed();
        } catch (Throwable ex) {
            log.error("Exception in " + methodInformation, ex);
            throw ex;
        } finally {
            log.info("Exiting :" + methodInformation);
        }
    }
}