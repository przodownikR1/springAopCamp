package pl.java.scalatech.training.impl;

import java.util.Random;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.training.CarService;
import pl.java.scalatech.training.car.Car;
@Component
@Slf4j
public class CarServiceImpl implements CarService{
    Random r = new Random();
    @Override
    public void clean() {
       log.info("+++ car clean service ...");       
        
    }

    @Override
    public void clean(String name) {
        log.info("+++ car clean service  name : {}...",name);
        
    }

    @Override
    public Car getCar(Car car, int position) {
        log.info("+++ car getCar service ...car : {} , position : {}",car,position);
        return car;
    }

    @Override
    public boolean checkEngine() {
        log.info("+++ car checkEngine service ...");
        return r.nextBoolean();
    }

    @Override
    public boolean checkEverythings(boolean ok) {
        log.info("+++ car checkEveryThing service ...flag : {}",ok);
        return ok;
    }

}
