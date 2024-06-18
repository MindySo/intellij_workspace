package kr.co.jhta.web.spring_web03;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("time");
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
        mav.addObject("msg", sdf.format(new Date()));
        return mav;
    }
}
