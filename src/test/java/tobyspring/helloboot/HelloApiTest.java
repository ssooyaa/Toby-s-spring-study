package tobyspring.helloboot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class HelloApiTest {

    @Test
    void helloApi() {
        //http://localhost:8080/hello?name=spring
        //RestTemplate 400/500대 에러시 예외를 던짐 상태코드와 콘텐츠 타입을 하나하나 확인하고 싶을 시 TestRestTemplate사용
        TestRestTemplate rest = new TestRestTemplate();

        ResponseEntity<String> res =
            rest.getForEntity("http://localhost:9090/app/hello?name={name}", String.class, "Spring");

        //status code 200
        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
        //heder(content-type) test/plain startsWith는 앞에값이 일치하면 됨
        assertThat(res.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);
        //body Hello Spring
        assertThat(res.getBody()).isEqualTo("Hello Spring");
    }

    @Test
    void failsHelloApi(){
        TestRestTemplate rest = new TestRestTemplate();

        ResponseEntity<String> res =
            rest.getForEntity("http://localhost:9090/app/hello?name=", String.class);

        //status code 500
        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
