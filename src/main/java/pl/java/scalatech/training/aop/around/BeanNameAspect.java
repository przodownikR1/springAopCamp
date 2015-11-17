package pl.java.scalatech.training.aop.around;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Profile("around")
@Slf4j
public class BeanNameAspect {

    private int called = 0;

    public void resetCalled() {
        called = 0;
    }

    public int getCalled() {
        return called;
    }





    @Around("bean(bikeService)")
    public void trace(ProceedingJoinPoint proceedingJP) throws Throwable {
        String methodInformation = proceedingJP.getStaticPart().getSignature().toString();
        log.info("Entering :" + methodInformation);
        called++;

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