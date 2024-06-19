package kr.co.jhta.web.spring_web_quiz01.control;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@NoArgsConstructor
@Controller
public class MemberController {

    MySQLMemberDAO dao = new MySQLMemberDAO();

    @GetMapping(value = "/join.do")
    public String join() {
        return "join";
    }

    @PostMapping("join.do")
    public String joinPost(@ModelAttribute MemberDTO dto){
        dao.insertOne(dto);
        return "redirect:/main.do";
    }

}
