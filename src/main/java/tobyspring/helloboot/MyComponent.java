package tobyspring.helloboot;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.stereotype.Component;

@Retention(RetentionPolicy.RUNTIME) //어노테이션이 언제까지 유지될 것인가
@Target(ElementType.TYPE)  //어노테이션이 적용될 대상
@Component
public @interface MyComponent {

}
