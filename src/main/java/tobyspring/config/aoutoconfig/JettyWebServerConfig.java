package tobyspring.config.aoutoconfig;

import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import tobyspring.config.ConditionalMyOnClass;
import tobyspring.config.MyAutoConfiguration;

@MyAutoConfiguration
@ConditionalMyOnClass("org.eclipse.jetty.server.Server")
public class JettyWebServerConfig {

    @Bean("jettyWebServerFactory")
    public ServletWebServerFactory servletWebServerFactory() {
        //빈으로 등록되는 오브젝트는 컨테이너 안에서 아이디가 부여됨
        //빈어노테이션으로 팩토리메소드에서 만들때는 메소드이름을 따라감
        //스프링 컨테이너 초기화 시 에러 나지 않도록 이름지정
        return new JettyServletWebServerFactory();
    }
}
