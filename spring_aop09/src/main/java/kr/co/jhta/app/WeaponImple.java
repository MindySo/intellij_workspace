package kr.co.jhta.app;

public class WeaponImple implements Weapon{
    String type;

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void fire() {
        System.out.println("fire");
    }

    @Override
    public void reload() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("reload");
    }
}
