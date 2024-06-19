package kr.co.jhta.web.spring_web06.control;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.jhta.web.spring_web06.dao.CommonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;

@Controller
public class HelloController {

    @Autowired
    CommonDAO dao;

    public void setDao(CommonDAO dao) {
        this.dao = dao;
    }

    @RequestMapping("/newWorld.do")
    public String hello() {
        return "newWorld";
    }

    @RequestMapping(value = "/login.do", method = RequestMethod.GET)
    public String loginForm() {
        return "loginForm";
    }

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public String loginOk(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        // 파라미터 값 가져오기
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");

        System.out.println("id: " + id + " / pw: " + pw);

        boolean result = dao.findByIdAndPw(id, pw);
        if(result != true){
            return  "loginForm";
        }
        model.addAttribute("id", id);
        return "loginOk";
    }

}
