package kr.co.jhta.app;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MessageImple2 implements Message, InitializingBean, DisposableBean {
    String name;

    public void setName(String name) {
        this.name = name;
    }

    // 커스텀 초기화 메서드
    public void init(){
        System.out.println("커스텀 초기화 메서드 호출중");
    }

    // 커스텀 종료 메서드
    public void destroy2(){
        System.out.println("커스텀 종료 메서드 호출중");
    }


    @Override
    public void printMsg() {
        System.out.println(name + "님 환영합니다");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // 12번째 단계에 실행되는 메서드
        System.out.println("12th : InitializingBean.afterPropertiesSet : 초기화 메서드가 호출됨");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("2th DisposableBean's destroy : 종료");
    }
}
