package pl.java.scalatech.training.impl;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.training.Service;
@Component
@Slf4j
public class ServiceImpl implements Service{

    @Override
    public void clean() {
         log.info("++++ clean service...");
        
    }

}
