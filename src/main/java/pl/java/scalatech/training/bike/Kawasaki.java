package pl.java.scalatech.training.bike;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Kawasaki extends Bike implements BikeService{
    
    @Override
    public void clean() {
    log.info("this  {}, method {}",this.getClass().getSimpleName(),"clean");

    }

    @Override
    public void checkTyres() {
        log.info("this  {}, method {}",this.getClass().getSimpleName(),"checkTyres");

    }

    @Override
    public Bike returnBike(Bike bike) {
        log.info("this  {}, bike: {}, method {}",this.getClass().getSimpleName(),bike,"returnBike");
        return bike;
    }

    @Override
    public Bike getByType(String type) {
        log.info("this  {}, type: {}, method {}",this.getClass().getSimpleName(),type,"returnBike");
        return this;
    }

    @Override
    public Bike getDummy() {
        log.info("this  {},  method {}",this.getClass().getSimpleName(),"getDummy");
        return this;
    }

}
