package dashboard;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard
@SpringBootApplication
@EnableEurekaClient
public class DashBoardApp {

    public static void main(String[] args){
        SpringApplication.run(DashBoardApp.class,args);
    }
}

