package pl.java.scalatech.jamon;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.config.AopProfiler;
import pl.java.scalatech.config.JamonPerformanceConfig;
import pl.java.scalatech.config.ServiceConfig;
import pl.java.scalatech.service.dummy.DummyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ServiceConfig.class,JamonPerformanceConfig.class,AopProfiler.class})
@Slf4j
public class JamonTest {
    @Autowired
    private DummyService dummyService;
    
    @Test
    public void shouldJamonWork(){
        Assertions.assertThat(dummyService.generateNumber()).isNotNull().isGreaterThan(0);
        log.info(" {} ",dummyService.generateNumber());
    }
   
}
