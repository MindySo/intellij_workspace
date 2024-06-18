package kr.co.jhta.web.spring_web04.control;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class SelectMenuController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        String[] menuList = request.getParameterValues("ck");

        return new ModelAndView("selectMenu", "menuList", menuList);
    }
}
