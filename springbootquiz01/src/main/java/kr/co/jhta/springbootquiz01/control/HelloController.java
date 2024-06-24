package kr.co.jhta.springbootquiz01.control;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Controller
public class HelloController {
    @RequestMapping("/time")
    public String time(Model model) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter.format(date));
        model.addAttribute("msg",formatter.format(date));
        return "time";
    }

    @RequestMapping("/test")
    public String hello(Model model) {
        model.addAttribute("msg", "안녕하세요");
        return "test";
    }

}
