package pl.java.scalatech.config;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.aop.interceptor.JamonPerformanceMonitorInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JamonPerformanceConfig {
    final private static String JAMON_ID = "jamon";
    @Bean(name=JAMON_ID)
    JamonPerformanceMonitorInterceptor jamonPerformanceInterceptor(){
        JamonPerformanceMonitorInterceptor jamon = new JamonPerformanceMonitorInterceptor();
        jamon.setTrackAllInvocations(true);
        jamon.setLoggerName("pl.java.scalatech.trace");
        jamon.setPrefix("=> ");
        jamon.setUseDynamicLogger(true);
        return jamon;
    }
    
   
    
    @Bean
    BeanNameAutoProxyCreator autoProxyCreator(){
        BeanNameAutoProxyCreator autoProxyCreator  = new BeanNameAutoProxyCreator();
        autoProxyCreator.setInterceptorNames("jamonPerformanceInterceptor");        
        autoProxyCreator.setBeanNames(JAMON_ID);
        return autoProxyCreator;
    }
    
    @Bean
    public Advisor performanceAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(public * pl.java.scalatech.service.dummy.*.*(..))");
        return new DefaultPointcutAdvisor(pointcut, jamonPerformanceInterceptor());
    }
    
      
}
