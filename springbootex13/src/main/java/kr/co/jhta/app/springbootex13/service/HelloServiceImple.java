package kr.co.jhta.app.springbootex13.service;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImple implements HelloService{
    @Override
    public String sayHello() {
        return "hello 둘리";
    }
}
