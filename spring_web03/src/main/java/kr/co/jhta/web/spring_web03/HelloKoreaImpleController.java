package kr.co.jhta.web.spring_web03;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloKoreaImpleController implements HelloKorea, Controller {

    NowTime nt;

    public void setNt(NowTime nt) {
        this.nt = nt;
    }

    @Override
    public String sayHelloKr() {
        int hour = nt.getHour();
        String helloKr = "";

        if(hour >= 6 && hour < 11) {
            helloKr = "안녕하세요.";

        } else if (hour >= 11 && hour < 16) {
            helloKr = "점심 식사하셨나요?";

        } else {
            helloKr = "좋은 저녁 되세요.";
        }
        return helloKr;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("helloKr");
        mav.addObject("msg", sayHelloKr());
        return mav;
    }
}
