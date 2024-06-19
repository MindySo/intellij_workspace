package kr.co.jhta.web.spring_web07.control;

import kr.co.jhta.web.spring_web07.dao.OracleDAO;
import kr.co.jhta.web.spring_web07.dto.MemberDTO;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@NoArgsConstructor
@Controller
public class JoinController {

    OracleDAO dao = new OracleDAO();

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
