package pl.java.scalatech.training.concrete;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.java.scalatech.training.config.AopConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AopConfig.class)
@ActiveProfiles("concrete")
public class ConcreteAopTest {
    @Autowired
    private MyConcreteService myConcreteService;
    
    @Test
    public void shouldAspectWork(){
        myConcreteService.sayHello("przodownik");
    }
}
