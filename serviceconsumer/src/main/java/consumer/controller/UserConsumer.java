package consumer.controller;


import consumer.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserConsumer {

    @Autowired
    private UserFeign userFeign;


    @RequestMapping(value="/userfeign",method = RequestMethod.GET)
    public String getUserThroughFeign(@RequestParam("id") String id) throws InterruptedException {
        return userFeign.getUser(id);
    }



}
