package kr.co.jhta.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        // BeanFactory : 빈 관리 기능
        // ApplicationContext : 빈 관리 기능 + 자원 처리 추상화, 메세지 지원 및 국제화 지원, 이벤트 지원

        ApplicationContext ac = new ClassPathXmlApplicationContext("app.xml");

        Character ch = ac.getBean("ch", Character.class);

        ch.eat("도넛");
        ch.walk();
        ch.attack("몬스터");
        ch.get("돌멩이");

    }
}
