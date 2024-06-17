package kr.co.jhta.app;

public class SlingShot implements Weapon{

    int bead;

    public SlingShot(int bead) {
        this.bead = bead;
    }

    public void fire(){
        if(bead > 0){
            System.out.println("슝");
            bead--;
        }else {
            System.out.println("구슬 없음");
        }
    }
    public void reload(){
        System.out.println("재장전");
        bead = 8;
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
