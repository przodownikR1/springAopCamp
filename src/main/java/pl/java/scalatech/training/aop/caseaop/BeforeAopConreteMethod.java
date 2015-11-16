package pl.java.scalatech.training.aop.caseaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.training.aop.LogJointpoint;
import pl.java.scalatech.training.bike.Bike;

@Aspect
@Component
@Slf4j
@Profile("concreteMethod")
public class BeforeAopConreteMethod extends LogJointpoint{
    @Pointcut("execution( *  pl.java.scalatech.training.bike.BikeService.checkTyres(..))")
    private void tyres(){}
    
    //@Before("tyres()")
    public void beforeTyres(JoinPoint joinPoint) {
        logJoinPoint(joinPoint);
      
    }
   
    //Bike getByType(String type);
    @Pointcut("execution( pl.java.scalatech.training.bike.Bike  pl.java.scalatech..BikeService.getByType(String))")
    private void getByType(){}
    
    @Before("getByType()")
    public void beforeType(JoinPoint joinPoint) {
        logJoinPoint(joinPoint);
      
    }
    
}
