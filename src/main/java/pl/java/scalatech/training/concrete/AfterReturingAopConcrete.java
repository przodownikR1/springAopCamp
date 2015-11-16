package pl.java.scalatech.training.concrete;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class AfterReturingAopConcrete {
    
    @Pointcut("execution( *  pl.java.scalatech.training.concrete.MyConcreteService.*(..))")
    public void all(){}
    
    @AfterReturning("all()")
    public void aspect() {
        log.info("+++  {}","test");

    }
    
    @Pointcut("within(@pl.java.scalatech.annotation.AopClass *)")
    public void withinClass() {
    }

    @Pointcut("execution(* *(..))")
    public void anyMethod() {
    }

    @AfterReturning("withinClass() && anyMethod()")
    public void whenControllerMethodReturns() {
        log.info("++++++++++++++++++++++++++++++++++++++++++++++++ ");
    }
}
