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

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String hello(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException();
        }
        return helloService.sayHello(name);
    }
//    requestcontroller의 경우 ResponseBody가 기본 설정 되어있음

    @GetMapping("/count")
    public String count(String name) {
        return name + ": " + helloService.countOf(name);
    }
}