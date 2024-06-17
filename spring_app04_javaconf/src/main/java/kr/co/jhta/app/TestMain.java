package kr.co.jhta.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        // xml로 받아오지 않고 자바 객체로 받아옴
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    
        Hello h = context.getBean("h", Hello.class);
        h.sayHello("뽀로로");

    }
}
