package pl.java.scalatech;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.Person;
import pl.java.scalatech.repository.PersonRepository;

@SpringBootApplication
@Slf4j
public class SpringAopCamp implements CommandLineRunner{

    @Autowired
    private PersonRepository personRepository;
    
    
    public static void main(String[] args) {
        SpringApplication.run(SpringAopCamp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
      personRepository.save(Person.builder().email("przodownikR1@gmail.com").firstname("slawek").birthDay(ZonedDateTime.now()).build());  
      log.info("{} ",personRepository.findAll());  
    }
}
