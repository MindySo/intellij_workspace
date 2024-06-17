package kr.co.jhta.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("app.xml");

        Message m = context.getBean("m2", Message.class);
        m.printMsg();

        AbstractApplicationContext aac = (AbstractApplicationContext) context;
        aac.close();

    }
}
