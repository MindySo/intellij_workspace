package kr.co.jhta.app;

public class StunGun implements Weapon{

    int battery;

    public StunGun(int battery) {
        this.battery = battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    @Override
    public void use() {

        if(battery >= 30){
            System.out.println("짜릿짜릿");
            battery -= 30;
        } else {
            System.out.println("배터리 없음");
        }
    }

    @Override
    public void reuse() {
        System.out.println("충전중...");
        battery = 100;
    }
}
