package pl.java.scalatech.training.bike;

import pl.java.scalatech.training.Service;

public interface BikeService extends Service{


    void checkTyres();

    Bike returnBike(Bike bike);

    Bike getByType(String type);
}
