package pl.java.scalatech.training.bike.impl;

import org.springframework.stereotype.Component;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.training.aop.Check;
import pl.java.scalatech.training.bike.Bike;
import pl.java.scalatech.training.bike.BikeService;
import pl.java.scalatech.training.bike.Kawasaki;
@Component
@Slf4j
@ToString
public class BikeServiceImpl implements BikeService {@Override
    
    public void clean() {
       log.info("+++ bike clean service ...");       
    }
    @Check
    @Override
    public void checkTyres() {
        log.info("+++ bike checkTyres service ...");
        
    }

    @Override
    public Bike returnBike(Bike bike) {
        log.info("+++ bike returnBike service ...bike : {}",bike);
        return bike;
    }

    @Override
    public Bike getByType(String type) {
        log.info("+++ bike getByType service ...type : {}",type);
        return new Kawasaki();
    }

}
