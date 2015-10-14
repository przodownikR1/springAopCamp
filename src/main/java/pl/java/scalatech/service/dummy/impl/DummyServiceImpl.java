package pl.java.scalatech.service.dummy.impl;

import java.util.Random;

import org.springframework.stereotype.Service;

import pl.java.scalatech.service.dummy.DummyService;

/**
 * @author Sławomir Borowiec 
 * Module name : springAopCamp
 * Creating time :  14 paź 2015 13:21:41
 
 */
@Service
public class DummyServiceImpl implements DummyService{

    private Random random = new Random();
    
    @Override
    public int generateNumber() {
        return random.nextInt(10);
    }
    

}
