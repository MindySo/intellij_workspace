package kr.co.jhta.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

public class Police implements Character {
//  annotation으로 hp value 주기
    @Value("100")
    int hp;

    // annotation으로 w에 맞는 값 자동으로 연결
    @Autowired
    // qualifier로 어떤 값을 찾아올 것인지 정하기
    @Qualifier("w")
    Weapon w;

    public Police() {
    }

    public Police(int hp, Weapon w) {
        this.hp = hp;
        this.w = w;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setW(Weapon w) {
        this.w = w;
    }

    @Override
    public void walk() {
        System.out.println("체력 : " + hp);
        System.out.println("경찰 walking");
    }

    @Override
    public void eat(String it) {
        System.out.println("경찰 eating" + it);
    }

    @Override
    public void attack(Object obj) {
        System.out.println(obj + "를 공격");
        w.use();
    }

    @Override
    public void get(Object obj) {
        System.out.println("경찰 " + obj + "획득");
    }
}
