package user.controller;


import api.dto.User;
import api.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class UserController implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Value("${from}")
    private String fromStr;

    @Autowired
    Environment environment;

    @Autowired
    DiscoveryClient client;

    @Autowired
    Registration registration;

    public String getUser(@RequestParam("id") String id) throws InterruptedException {
        logger.info("this api.service called");
        ServiceInstance instance = serviceInstance();
        if(instance==null) return "";
        int sleepTime = new Random().nextInt(5000);
        Thread.sleep(sleepTime);
        logger.info(String.valueOf(sleepTime));
        logger.info(
                "/user, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
        User user = new User(id,"MZZ"+fromStr);
        String result = JSONObject.toJSONString(user);
        return result;
    }

    public ServiceInstance serviceInstance() {
        List<ServiceInstance> list = client.getInstances(registration.getServiceId());
        if (list != null && list.size() > 0) {
            for(ServiceInstance itm : list){
                if(String.valueOf(itm.getPort()) .equals(environment.getProperty("local.server.port")))
                    return itm;
            }
        }
        return null;
    }
}
