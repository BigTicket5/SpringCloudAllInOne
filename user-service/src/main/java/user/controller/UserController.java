package user.controller;


import api.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController implements IUserService {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value="/getUserById",method = RequestMethod.GET)
    public String getUser(@RequestParam("id") String id) {
        System.out.println("server on fire");
        return "test";
    }
}
