package consumer.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("helloservice")
public interface helloFeign {
    @RequestMapping("/sayhello")
    String hello();
}
