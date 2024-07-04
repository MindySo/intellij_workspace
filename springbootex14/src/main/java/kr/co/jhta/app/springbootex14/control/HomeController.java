package kr.co.jhta.app.springbootex14.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public void home() {
        System.out.println("home");
    }

    @GetMapping("/about")
    public void about() {
        System.out.println("월급을 많이 드립니다");
    }

    @GetMapping("/product")
    public void product() {
        System.out.println("product");
    }

    @GetMapping("/customer")
    public void customer() {
        System.out.println("customer");
    }


}
