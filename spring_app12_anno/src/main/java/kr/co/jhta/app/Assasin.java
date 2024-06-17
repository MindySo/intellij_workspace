package kr.co.jhta.app;

public class Assasin implements Character{

    int hp;
    Weapon w;

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setW(Weapon w) {
        this.w = w;
    }

    @Override
    public void walk() {
        System.out.println("암살자 걸어감");
    }

    @Override
    public void eat(String it) {
        System.out.println("암살자가 " + it + "을 먹음");

    }

    @Override
    public void attack(Object obj) {
        System.out.println("암살자가 "+ obj + "를 공격");

    }

    @Override
    public void get(Object obj) {
        System.out.println("암살자가 "+ obj + "를 획득");

    }
}
