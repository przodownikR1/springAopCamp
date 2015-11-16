package pl.java.scalatech.training.concrete;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.annotation.AopClass;

@Slf4j
@Component
@AopClass
public class MyConcreteService {

    public void sayHello(String name){
        log.info("hello  {}",name);
    }
    
}
