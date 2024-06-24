package kr.co.jhta.web.springbootex04.control;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// 로거
@Slf4j  // for java
@Controller
public class HomeController {
    @RequestMapping("/home")
    public String home(Model model) {
        log.info("Logger ===================>>>>>>>>>>");
        System.out.println("HomeController.home() =====================>");
        model.addAttribute("msg", "Hello World");
        return "home";
    }
}
