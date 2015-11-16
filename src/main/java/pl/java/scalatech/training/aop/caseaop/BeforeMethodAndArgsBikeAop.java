package pl.java.scalatech.training.aop.caseaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.training.aop.LogJointpoint;
import pl.java.scalatech.training.bike.Bike;
import pl.java.scalatech.training.bike.BikeService;
import pl.java.scalatech.training.bike.Kawasaki;
import pl.java.scalatech.training.config.AopConfig;
@Aspect
@Component
@Slf4j
@Profile("methodArgsBike")
public class BeforeMethodAndArgsBikeAop extends LogJointpoint{

 
    @Pointcut("args(bike)")
    public void somePointcut(Bike bike) {
    }

    @Before("somePointcut(bike)")
    public void somePointcutDemo(JoinPoint jp,Bike bike) {
        logJoinPoint(jp);
    }
    
   
  /*  @Pointcut("execution(* pl..BikeService+.get*(*))")  
    private void getMethodAdv(){}
    
    @Before("getMethodAdv() && args(pl.java.scalatech.training.bike.Bike)")
    public void beforeAdv(JoinPoint joinPoint, Bike bike){
        logJoinPoint(joinPoint);
        log.info("+++ type : {}",bike);
        
    }*/
}
