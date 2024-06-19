package kr.co.jhta.web.spring_web_quiz01.control;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("main.do")
    public String main() {
        return "main";
    }

    @RequestMapping("logout.do")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/main.do";
    }

}
