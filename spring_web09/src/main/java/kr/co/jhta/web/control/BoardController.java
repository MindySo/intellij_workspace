package kr.co.jhta.web.control;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import kr.co.jhta.web.dto.BoardDTO;
import kr.co.jhta.web.service.BoardService;
import kr.co.jhta.web.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
            @Qualifier("mysqlService")
    BoardService service;

    @RequestMapping("/list")
    public String list(Model model, @RequestParam(name = "currentPage", defaultValue = "1")int currentPage) {

        // 총 게시물 수
        int totalNumber = service.getTotal();

        // 페이지 당 게시물 수
        int countPerPage = 10;

        Map<String, Object>map = PageUtil.getPageData(totalNumber, countPerPage, currentPage);
        model.addAttribute("map", map);

        List<BoardDTO> list = service.readAll((Integer)map.get("startNo"), (Integer)map.get("endNo"));
        model.addAttribute("list", list);
        return "list";
    }

    @GetMapping("/write")
    public String write() {
        return "writeForm";
    }
    @PostMapping("/write")
    public String writeOk(@ModelAttribute BoardDTO dto, HttpServletRequest req) {
        System.out.println("dto : " + dto);
        String ip = req.getRemoteAddr();
        service.write(dto);
        return "redirect:/board/list";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("bno") int bno, Model model) {
        BoardDTO dto = service.readOne(bno);
        model.addAttribute("board", dto);
        return "detail";
    }

//  @GetMapping("/delete")
//  public String deleteOk(@RequestParam("bno") int bno, HttpServletRequest req) {
    @GetMapping("/delete/{no}")
    public String deleteOk(@PathVariable("no") int bno, HttpServletRequest req) {
        service.dropOne(bno);
        return "redirect:/board/list";
    }

    @GetMapping("/modify")
    public String modify(@RequestParam("bno") int bno, Model model) {
        BoardDTO dto = service.readOne(bno);
        model.addAttribute("board", dto);
        return "modifyForm";
    }

    @PostMapping("/modify")
    public String modifyOk(@ModelAttribute BoardDTO dto, HttpServletRequest req) {
        System.out.println("dto : " + dto);
        service.updateOne(dto);
        return "redirect:/board/list";
    }


}
