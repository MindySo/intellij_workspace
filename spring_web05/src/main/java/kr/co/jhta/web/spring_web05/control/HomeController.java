package kr.co.jhta.web.spring_web05.control;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/home.do")
    public ModelAndView home() {
        System.out.println("home() method called");
        return new ModelAndView("home");
   }

   @RequestMapping("/home2.do")
   public ModelAndView home2() {
       System.out.println("home2() method called");
       return new ModelAndView("home2");
   }
   @RequestMapping("doTest.do")
   public String aaa(){
       System.out.println("aaa() method called");
       return "test2";  // 뷰 이름
   }

   @RequestMapping(value="doTest2.do", method = RequestMethod.GET)
    public String bbb(){
        return "test3";
   }
   @RequestMapping(value="doTest2.do", method = RequestMethod.POST)
    public String ccc(){
        return "test4";
   }

   // 위의 것 줄인 방식
   @GetMapping("doGet1.do")
    public String ddd() {
        return "getTest";
    }

   @PostMapping("doPost1.do")
    public String eee() {
        return "postTest";
    }

    @GetMapping("/doGet2.do")
    public String fff(HttpServletRequest request,
                      HttpServletResponse response,
                      HttpSession session,
                      Model model) {
        String hostName = request.getServerName();

        // 데이터 전달
        model.addAttribute("hostName", hostName);
        return "getTest";
    }

    @RequestMapping("/home3.do")
    public String home3() {
        System.out.println("home3() method called");
        return "data/home3";
    }

    @RequestMapping("/hello.do")
    @ResponseBody
    public String ggg(){
        // ResponseBody : 뷰의 이름이 아니라 출력결과를 사용자 브라우저에 직접 보내기
        return "<html><body><h1>Hello World!</h1></body></html>";
    }


}
