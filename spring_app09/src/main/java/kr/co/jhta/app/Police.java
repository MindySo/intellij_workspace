package kr.co.jhta.app;

public class Police implements Character{

    int hp;
    Weapon w;

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setW(Weapon w) {
        this.w = w;
    }

    public Police(int hp, Weapon w) {
        this.hp = hp;
        this.w = w;
    }

    @Override
    public void walk() {
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
