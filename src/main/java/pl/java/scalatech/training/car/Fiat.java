package pl.java.scalatech.training.car;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.training.CarService;
@Slf4j
public class Fiat extends Car implements CarService{

    @Override
    public void clean() {
     log.info("this  {}, method {}",this.getClass().getSimpleName(),"clean");

    }

    @Override
    public void clean(String name) {
        log.info("this  {}, name : {} , method {}",this.getClass().getSimpleName(),name,"clean");

    }

    @Override
    public Car getCar(Car car, int position) {
        log.info("this  {}, car : {} , position : {} , method {}",this.getClass().getSimpleName(),car,position,"clean");
        return car;
    }

    @Override
    public boolean checkEngine() {
        log.info("this  {}, method {}",this.getClass().getSimpleName(),"checkEngine");
        return true;
    }

    @Override
    public boolean checkEverythings(boolean ok) {
        log.info("this  {}, condition :{}, method {}",this.getClass().getSimpleName(),ok,"clean");
        return false;
    }

}
