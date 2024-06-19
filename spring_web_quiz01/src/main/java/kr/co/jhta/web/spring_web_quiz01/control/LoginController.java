package kr.co.jhta.web.spring_web_quiz01.control;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    MySQLMemberDAO dao = new MySQLMemberDAO();

    @GetMapping("login.do")
    public String login(HttpSession session) {
        return "loginForm";
    }

    @PostMapping(value = "/login.do")
    public String loginOk(@RequestParam("id")String id,
                            @RequestParam("pw")String pw,
                             HttpSession session) {
      boolean result = dao.findByIdAndPw(id, pw);
      if(!result) {
          return "redirect:login.do";
      }

      session.setAttribute("id", id);
      return "redirect:main.do";
    }
}
