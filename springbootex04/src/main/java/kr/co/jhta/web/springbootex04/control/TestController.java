package kr.co.jhta.web.springbootex04.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class TestController {
    // 사용자 브라우저에 직접 데이터를 전달
    @GetMapping("/show")
    @ResponseBody
    public String showData(){
        return "msg: {Hello World}";
    }
}
