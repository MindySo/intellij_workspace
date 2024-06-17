package kr.co.jhta.app;

public class BankImple implements Bank {

    String name;
    int balance;

    @Override
    public void transfer(int money) {
        System.out.println(name + " transfer " + money + " from " + balance);
        balance -= money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
