package pl.java.scalatech.training.aop.throwing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.java.scalatech.training.bike.BikeService;
import pl.java.scalatech.training.config.AopConfig;
//import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AopConfig.class)
@ActiveProfiles("throwing")
public class ThrowingTest {

    //@Rule
    //public final StandardOutputStreamLog log =new StandardOutputStreamLog();

    @Autowired
    private BikeService bikeService;

    @Test
    public void shouldBeforeWork(){


        bikeService.thTest(true);



    }

}
