package tobyspring.helloboot;

import org.springframework.stereotype.Component;

@MyComponent
public interface HelloService {

    String sayHello(String name);
}
