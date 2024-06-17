package kr.co.jhta.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
    public static void main(String[] args) {

        ApplicationContext factory = new ClassPathXmlApplicationContext("app.xml");
        GuGuDanInter ggd = factory.getBean("ggd", GuGuDanInter.class);
        ggd.print();
    }
}
