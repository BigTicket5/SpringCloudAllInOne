package consumer.service;

import consumer.feign.UserFeign;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/user/fallback")
public class UserServiceFallback implements UserFeign {
    @Override
    public String getUser(String id) throws InterruptedException {
        return "error";
    }
}
