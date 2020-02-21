package user.controller;



import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@CrossOrigin(origins = "*")
public class helloController {

    @RequestMapping(value="/sayhello",method = RequestMethod.GET)
    public String sayHello(){
        log.info("server {}", "is shit");
        return "{\n" +
                "  \"status\":{\n" +
                "    \"status_code\":\"200\",\n" +
                "    \"status_name\":\"io\"\n" +
                "  },\n" +
                "  \"data\":[{\n" +
                "    \"parameterTypeCode\":\"1\",\n" +
                "    \"parameterTypeName\":\"center\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"parameterTypeCode\":\"2\",\n" +
                "    \"parameterTypeName\":\"sort\"\n" +
                "  }\n" +
                "  ]\n" +
                "}";
    }

    @RequestMapping(value="/saveApi",method = RequestMethod.POST)
    public void saveParam(@RequestBody Object obj){
        System.out.println(obj);
    }
}
