package kr.co.jhta.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(kr.co.jhta.app.AppConfig.class);
        Printer p = context.getBean("p", Printer.class);
        p.print("Hello World");
    }
}
