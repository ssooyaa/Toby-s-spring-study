package tobyspring.helloboot;

import java.util.Objects;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String hello(String name) {
        return helloService.sayHello(Objects.requireNonNull(name));
    }
//    requestcontroller의 경우 ResponseBody가 기본 설정 되어있음
}