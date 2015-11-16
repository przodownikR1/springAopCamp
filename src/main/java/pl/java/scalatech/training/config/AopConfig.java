package pl.java.scalatech.training.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages="pl.java.scalatech.training")
public class AopConfig {

}
