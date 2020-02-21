package consumer.feign;


import api.service.UserService;
import consumer.service.UserServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "service-e",fallback = UserServiceFallback.class)
public interface UserFeign  extends UserService {
}
