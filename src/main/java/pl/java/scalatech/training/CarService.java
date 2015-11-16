package pl.java.scalatech.training;

import pl.java.scalatech.training.car.Car;

public interface CarService extends Service{



    void clean(String name);

    Car getCar(Car car, int position);

    boolean checkEngine();

    boolean checkEverythings(boolean ok);


}
