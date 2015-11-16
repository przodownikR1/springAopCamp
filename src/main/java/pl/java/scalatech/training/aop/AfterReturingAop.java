package pl.java.scalatech.training.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class AfterReturingAop {

    @Pointcut("@annotation(pl.java.scalatech.annotation.CatchException) || within(@org.springframework.stereotype.Service *) ")
    private void serviceExLog() {}

    @AfterReturning(value = "")
    public void before() {

        log.info("+++  {}",);

    }
}