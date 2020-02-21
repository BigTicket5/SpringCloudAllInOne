package consumer;


import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
@ServletComponentScan
public class app {

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

    public static void main(String[] args) {
        SpringApplication.run(app.class, args);
    }
}
