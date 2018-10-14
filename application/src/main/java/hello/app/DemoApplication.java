package hello.app;

import hello.service.MyService;
import hello.service.ValidationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = {"hello.app", "hello.service"})
@RestController
@EnableScheduling
public class DemoApplication {

    //@Autowired
    private final MyService myService;
    private final ValidationService validationService;

    public DemoApplication(MyService myService, ValidationService validationService) {
        this.validationService = validationService;
        this.myService = myService;
    }

    @GetMapping("/")
    public String home() {
        return myService.message();
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        validationService.addSth("11", 1);

        return "test";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
