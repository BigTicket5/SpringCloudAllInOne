package consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class gethelloController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value="/sayhello",method = RequestMethod.GET)
    public  String sayh(){
        return restTemplate.getForObject("http://SERVICE-E/sayhello",String.class);
    }

}
