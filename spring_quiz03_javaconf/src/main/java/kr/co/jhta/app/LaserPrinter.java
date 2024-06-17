package kr.co.jhta.app;

public class LaserPrinter implements Printer {

    @Override
    public void print(String msg) {
        System.out.println("레이저프린트 : " + msg);
    }
}
