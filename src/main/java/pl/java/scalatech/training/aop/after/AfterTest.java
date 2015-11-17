package pl.java.scalatech.training.aop.after;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.java.scalatech.training.bike.BikeService;
import pl.java.scalatech.training.bike.Kawasaki;
import pl.java.scalatech.training.config.AopConfig;
//import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AopConfig.class)
@ActiveProfiles("after")
public class AfterTest {

    //@Rule
    //public final StandardOutputStreamLog log =new StandardOutputStreamLog();

    @Autowired
    private BikeService bikeService;

    @Test
    public void shouldBeforeWork(){

        bikeService.checkTyres();
        bikeService.getByType("suzuki");
        bikeService.getDummy();

        bikeService.returnBike(new Kawasaki());



    }

}
