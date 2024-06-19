package kr.co.jhta.web.spring_web07.control;

import kr.co.jhta.web.spring_web07.dao.OracleDAO;
import kr.co.jhta.web.spring_web07.dto.DeptDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DeptController {

    @Autowired
    OracleDAO dao = new OracleDAO();

    @GetMapping("showDept.do")
    public String showDept(Model model) {
        List<DeptDTO> list = dao.selectDeptList();
        model.addAttribute("list", list);
        return "showDept";
    }

}
