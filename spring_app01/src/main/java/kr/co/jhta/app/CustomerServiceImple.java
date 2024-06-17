package kr.co.jhta.app;

public class CustomerServiceImple implements CustomerService{

    String name;
    String email;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void printName() {
        System.out.println("Name: " + name);
    }

    @Override
    public void printEmail() {
        System.out.println("Email: " + email);
    }
}
