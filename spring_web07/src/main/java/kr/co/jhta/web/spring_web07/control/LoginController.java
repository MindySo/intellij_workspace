package kr.co.jhta.web.spring_web07.control;

import jakarta.servlet.http.HttpSession;
import kr.co.jhta.web.spring_web07.dao.OracleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;

@Controller
public class LoginController {

    @Autowired
    OracleDAO dao = new OracleDAO();

    @GetMapping("login.do")
    public String login(HttpSession session) {
        return "loginForm";
    }

    @PostMapping(value = "/login.do")
    public String loginOk(@RequestParam("id")String id,
                          @RequestParam("pw")String pw,
//                          @RequestParam("cnt") int cnt,
                          HttpSession session) throws UnsupportedEncodingException {

        System.out.println("id: " + id + " / pw" + pw);

        boolean result = dao.findByIdAndPw(id, pw);
        if(!result){
            return "redirect:login.do";
        }

        //로그인 성공 후에 실행되는 코드
        session.setAttribute("id", id);
        return "redirect:main.do";
    }

    @RequestMapping("logout.do")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/main.do";
    }

}
