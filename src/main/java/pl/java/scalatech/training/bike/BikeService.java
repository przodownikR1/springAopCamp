package pl.java.scalatech.training.bike;


public interface BikeService {



    void checkTyres();

    Bike returnBike(Bike bike);

    Bike getByType(String type);

   void thTest(boolean th);


    Bike getDummy();

}
