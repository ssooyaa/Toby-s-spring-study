package tobyspring.helloboot;

@MySpringBootApplication
public class HellobootApplication {

    public static void main(String[] args) {
//        GenericWebApplicationContext는 java로 만든 Configuration 정보를 읽을 수 없다.

        MySpringApplication.run(HellobootApplication.class, args);

    }


}
