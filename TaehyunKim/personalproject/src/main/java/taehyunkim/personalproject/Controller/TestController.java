package taehyunkim.personalproject.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/")
public class TestController{

    @GetMapping
    @ResponseBody
    public String test(){
        log.info("Testing Spring Boot...");
        return "hello";
    }
}
