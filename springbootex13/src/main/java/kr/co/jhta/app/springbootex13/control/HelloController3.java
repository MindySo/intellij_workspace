package kr.co.jhta.app.springbootex13.control;

import kr.co.jhta.app.springbootex13.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController3 {
    private final HelloService helloService;

    @GetMapping("/sayHi")
    public String sayHi() {
        return helloService.sayHello();
    }
}
