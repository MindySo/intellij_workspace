package kr.co.jhta.app.springbootex09.control;

import kr.co.jhta.app.springbootex09.entity.Member;
import kr.co.jhta.app.springbootex09.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MainController {
    private final MemberRepository memberRepository;

    @GetMapping("/info")
    public String info(Model model) {
        List<Member> list = memberRepository.findAll();

        model.addAttribute("msg", "hello");
        model.addAttribute("list", list);
        return "info";
    }

    @GetMapping("/add")
    public String add(Model model) {
        return "addForm";
    }

    @PostMapping("/addOk")
    public String add(@ModelAttribute Member member) {
        memberRepository.save(member);
        return "redirect:/member/info";
    }

    @GetMapping("/delete/{num}")
    public String delete(@PathVariable int num) {
        memberRepository.deleteById(num);
        return "redirect:/member/info";
    }

    @GetMapping("/updateForm/{num}")
    public String update(@PathVariable int num, Model model) {
        Member member = memberRepository.findById(num).get();
        model.addAttribute("member", member);
        return "updateForm";
    }

    @PostMapping("/updateOk")
    public String update(@ModelAttribute Member member) {
        memberRepository.save(member);
        return "redirect:/member/info";
    }



}
