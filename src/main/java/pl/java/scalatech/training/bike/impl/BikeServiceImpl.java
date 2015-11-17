package pl.java.scalatech.training.bike.impl;

import org.springframework.stereotype.Component;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.annotation.AopClass;
import pl.java.scalatech.annotation.AopMethod;
import pl.java.scalatech.training.aop.Check;
import pl.java.scalatech.training.bike.Bike;
import pl.java.scalatech.training.bike.BikeService;
import pl.java.scalatech.training.bike.Kawasaki;
import pl.java.scalatech.training.bike.Yamaha;
@Component
@Slf4j
@ToString
@AopClass
public class BikeServiceImpl implements BikeService {


    @Check(logText="slawek")
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

    @AopMethod(str="hubabuba")
    @Override
    public Bike getDummy() {
        log.info("+++ bike getDummy service .,,");
        return new Yamaha();
    }

    @Override
    public void thTest(boolean th) {
        if(th) {
            throw new IllegalArgumentException();
        }
       log.info("+++ thTest .,,");

    }

}
