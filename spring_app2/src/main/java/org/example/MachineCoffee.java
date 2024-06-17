package org.example;

public class MachineCoffee implements Beverage {
    String snack;

    public void setSnack(String snack) {
        this.snack = snack;
    }

    @Override
    public void drink(String name) {
        System.out.println(name + "님이 아메리카노와 " + snack + "을(를) 먹어요");
    }
}
