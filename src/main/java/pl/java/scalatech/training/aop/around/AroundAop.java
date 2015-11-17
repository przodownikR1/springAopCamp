package pl.java.scalatech.training.aop.around;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.annotation.AopMethod;

@Component
@Aspect
@Profile("aroundAnnotation")
@Slf4j
public class AroundAop {

     @Around("execution (@pl.java.scalatech.annotation.AopMethod * *(..))")
     public void trace1(ProceedingJoinPoint proceedingJP) throws Throwable {
         String methodInformation = proceedingJP.getStaticPart().getSignature().toString();
         log.info("Entering 111: {} " , methodInformation);

         try {
             proceedingJP.proceed();
         } catch (Throwable ex) {
             log.error("Exception 111in {}, {}" , methodInformation, ex);
             throw ex;
         } finally {
             log.info("Exiting 11: {}" , methodInformation);
         }
     }
    //@Around("execution (@annotation.AppMethod * *(..))")


    @Pointcut("@annotation(aopMethod1)")
    protected void logAnnotatedMethods(AopMethod aopMethod1) {
    }

   //@Around("@annotation(pl.java.scalatech.annotation.AopMethod) && within(@org.springframework.stereotype.Component *) ") //ok
   // @Around("@annotation(pl.java.scalatech.annotation.AopMethod)") //ok
    @Around("logAnnotatedMethods(aopMethod2)")
    public void trace(ProceedingJoinPoint proceedingJP,AopMethod aopMethod2) throws Throwable {
        String methodInformation = proceedingJP.getStaticPart().getSignature().toString();
        log.info("Entering : {} ,{}" , methodInformation,aopMethod2.str());

        try {
            proceedingJP.proceed();
        } catch (Throwable ex) {
            log.error("Exception in {}, {}" , methodInformation, ex);
            throw ex;
        } finally {
            log.info("Exiting : {}" , methodInformation);
        }
    }
}
