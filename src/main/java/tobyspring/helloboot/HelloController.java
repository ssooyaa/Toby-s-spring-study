package tobyspring.helloboot;

import java.util.Objects;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final HelloService helloService;
    private ApplicationContext applicationContext;

    public HelloController(HelloService helloService, ApplicationContext applicationContext) {
        this.helloService = helloService;
        this.applicationContext = applicationContext;
    }

    @GetMapping("/hello")
    public String hello(String name) {
        return helloService.sayHello(Objects.requireNonNull(name));
    }
//    requestcontroller의 경우 ResponseBody가 기본 설정 되어있음
}