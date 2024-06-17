package kr.co.jhta.app;

public class GuGuDanImple implements GuGuDanInter{

    int dan;

    public GuGuDanImple(int dan) {
        this.dan = dan;
    }

    @Override
    public void print() {
        for (int i = 1 ; i < 10 ; i++) {
            System.out.println(dan + " x " + i + " = " + dan*i);
        }
    }
}
