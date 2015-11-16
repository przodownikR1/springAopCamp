package pl.java.scalatech.training.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.java.scalatech.training.bike.BikeService;
import pl.java.scalatech.training.config.AopConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AopConfig.class)
public class BeforeTest {

    @Autowired
    private BikeService bikeService;
    
    @Test
    public void shouldBeforeWork(){
        
        bikeService.checkTyres();
    }
    
}
