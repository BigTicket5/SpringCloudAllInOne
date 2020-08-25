package consumer.feign;


import api.service.IUserService;
import consumer.service.UserServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "user-service",fallback = UserServiceFallback.class)
public interface UserFeign  extends IUserService {

}
