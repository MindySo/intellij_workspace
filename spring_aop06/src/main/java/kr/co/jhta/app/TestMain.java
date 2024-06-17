package kr.co.jhta.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        // spring 실행
        ApplicationContext context = new ClassPathXmlApplicationContext("app.xml");
        CustomerService cs = (CustomerService) context.getBean("cs");

        // 당신의 이름 : 루피
        // 당신의 email : loopy@gmail.com
        cs.printName();
        cs.printEmail();
    }

    public static class CustomerServiceImple implements CustomerService{
        String name;
        String email;

        public void setName(String name) {
            this.name = name;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public void printName() {
            System.out.println("name: " + name);
        }

        @Override
        public void printEmail() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("email: " + email);
        }
    }
}
