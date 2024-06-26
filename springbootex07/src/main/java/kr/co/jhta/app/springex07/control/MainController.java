package kr.co.jhta.app.springex07.control;

import kr.co.jhta.app.springex07.dao.OracleDAO;
import kr.co.jhta.app.springex07.dto.DeptDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/list")

// 생성자로 불러옴
@RequiredArgsConstructor
public class MainController {

    // dao 바꾸지 못하게
    private final OracleDAO dao;

    //  /list+/ ==> /list/
    @GetMapping("")
    public String list(Model model){
        log.info("dao :: ==========================>" + dao);
        List<DeptDTO> list = dao.selectDeptList();
        model.addAttribute("list", list);
        return "list";
    }

    @GetMapping("/one") // /list + /one => /list/one
    public String one(@RequestParam String deptno,
                      @RequestParam String dname,
                      @RequestParam String loc,
                      Model model){
        model.addAttribute("deptno", deptno);
        model.addAttribute("dname", dname);
        model.addAttribute("loc", loc);
        return "one";
    }

}
