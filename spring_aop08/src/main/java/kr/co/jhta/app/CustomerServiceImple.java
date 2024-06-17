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
        System.out.println("name: " + name);
    }

    @Override
    public void printEmail() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("email: " + email);
    }
}
