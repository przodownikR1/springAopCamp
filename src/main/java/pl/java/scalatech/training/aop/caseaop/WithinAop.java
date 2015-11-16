package pl.java.scalatech.training.aop.caseaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.annotation.AopMethod;
import pl.java.scalatech.training.aop.LogJointpoint;

@Aspect
@Component
@Slf4j
@Profile("within")
public class WithinAop extends LogJointpoint{
    
    @Pointcut("within(pl.java.scalatech.training.bike.BikeService+)")  
    private void withinPointcut(){}
    
    
    @Pointcut("within(@org.springframework.stereotype.Component  pl.java.scalatech.training..*)")
    public void somePointcut() {
    }
   
    @Pointcut("within(@org.springframework.stereotype.Component *)")
    public void componentBean() {}
    
   
    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void controllerBean() {
   
    }
   /* @Pointcut("@annotation(pl.java.scalatech.annotation.AopMethod)")
    public void annotationMethod() {
        
    }*/
    //TODO
    @Pointcut("@within(pl.java.scalatech.annotation.AopMethod)")
    public void withinMethod() {
        
    }
    
    @Before("withinMethod()")
    public void annotationMethodTest(JoinPoint joinPoint){
        log.info("+++++++++++++ annotation method");
        logJoinPoint(joinPoint);
      
    }
    
/*    @Before("somePointcut()")
    public void beforeWithin(JoinPoint joinPoint){
        logJoinPoint(joinPoint);
      
    }*/
}
