package kr.co.jhta.web.springbootex10.control;

import kr.co.jhta.web.springbootex10.domain.Dept;
import kr.co.jhta.web.springbootex10.domain.Emp;
import kr.co.jhta.web.springbootex10.repository.DeptRepository;
import kr.co.jhta.web.springbootex10.repository.EmpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/info")
@RequiredArgsConstructor
public class MainController {
    private final DeptRepository deptRepository;
    private final EmpRepository empRepository;

    // db에 가서 사원들 전체 목록을 가져오고
    // empinfo 뷰로 전달
    // 뷰 : table 형식으로 출력 : thymeleaf, bootstrap
    // 사원명을 클릭하면 (/info/getOne/7788)
    // 부서의 정보를 가져와서 deptInfo 뷰 전달 : 표로 출력
    @GetMapping("/empInfo")
    public String empinfo(Model model) {
        List<Emp> list = empRepository.findAll();
        model.addAttribute("list", list);
        return "empInfo";
    }

    @GetMapping("/getOne/{empno}")
    public String deptInfo(@PathVariable("empno") Long empno, Model model) {
        Emp emp = empRepository.findByEmpno(empno);
        Optional<Dept> dept = deptRepository.findById(emp.getDept().getDeptno());
        model.addAttribute("dept", dept);
        return "deptInfo";
    }
}
