public class WeaponImple implements WeaponInter{

    @Override
    public void fire() {
        System.out.println("빵");
    }

    @Override
    public void reload() {
        System.out.println("재장전");
    }
}
