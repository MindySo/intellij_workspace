package kr.co.jhta.app;

public class HelloImple implements Hello{
    @Override
    public void sayHello(String name) {
        System.out.println(name + "!!! say hello  :)");
    }
}
