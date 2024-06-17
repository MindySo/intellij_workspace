package kr.co.jhta.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext factory = new ClassPathXmlApplicationContext("app.xml");
        Airplane p = factory.getBean("p", Airplane.class);
        p.takeOff();
        p.fly();
        p.landing();
    }
}
