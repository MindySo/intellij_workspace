package kr.co.jhta.app;

public class Gun implements Weapon{
    int bullet;

    public Gun(int bullet) {
        this.bullet = bullet;
    }

    public void fire(){
        if(bullet > 0){
            System.out.println("빵");
            bullet--;
        }else {
            System.out.println("틱");
        }
    }
    public void reload(){
        System.out.println("재장전");
        bullet = 8;
    }

    @Override
    public void use() {
        fire();
    }

    @Override
    public void reuse() {
        reload();
    }
}
