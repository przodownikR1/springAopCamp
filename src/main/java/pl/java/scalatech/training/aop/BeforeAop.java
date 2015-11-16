package pl.java.scalatech.training.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.aop.ExceptionLogger;
import pl.java.scalatech.service.log.LoggerExceptionService;
@Aspect
@Component
@Slf4j
public class BeforeAop {

    @Pointcut("@annotation(pl.java.scalatech.annotation.CatchException) || within(@org.springframework.stereotype.Service *) ")
    private void serviceExLog() {}

    @Before(value = "")
    public void before() {

        log.info("+++  {}",);

    }
}