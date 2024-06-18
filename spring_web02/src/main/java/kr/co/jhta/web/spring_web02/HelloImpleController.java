package kr.co.jhta.web.spring_web02;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloImpleController implements Hello, Controller {

    String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String sayHello() {
        return "Hello, " + name + "!";
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("welcomeHome");
        mav.addObject("msg", sayHello());
        return mav;
    }
}
