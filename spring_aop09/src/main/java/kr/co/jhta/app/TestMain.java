package kr.co.jhta.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("app.xml");
        Weapon w = ac.getBean("w", Weapon.class);
        w.fire();
        w.reload();

    }
}
