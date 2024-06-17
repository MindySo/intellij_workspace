package kr.co.jhta.app;

public class FX21 implements Airplane{
    private Missile m;

    public void setM(Missile m) {
        this.m = m;
    }

    @Override
    public void takeOff() {
        System.out.println("FX21 전투기가 이륙합니다");
    }

    @Override
    public void landing() {
        System.out.println("FX21 전투기가 착륙합니다");
    }

    @Override
    public void fly() {
        System.out.println("FX21 전투기가 하늘을 납니다");
    }
}
