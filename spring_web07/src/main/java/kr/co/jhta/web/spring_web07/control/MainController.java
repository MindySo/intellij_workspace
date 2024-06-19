package kr.co.jhta.web.spring_web07.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping("main.do")
    public String main() {
        return "main";
    }
}
