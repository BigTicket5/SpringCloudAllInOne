package api.service;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/user")
public interface UserService  {

    @RequestMapping(value = "/getUserById",method = RequestMethod.GET)
    String getUser (@RequestParam("id") String id)throws InterruptedException ;
}
