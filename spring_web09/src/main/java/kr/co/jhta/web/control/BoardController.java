package kr.co.jhta.web.control;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import kr.co.jhta.web.dto.BoardDTO;
import kr.co.jhta.web.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService service;

    @RequestMapping("/list")
    public String list(Model model) {
        List<BoardDTO> list = service.ReadAll();
        model.addAttribute("boards", list);
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

    @PostMapping("/detail")
    public String deleteOk(@RequestParam("bno") int bno, HttpServletRequest req) {
        service.dropOne(bno);
        return "redirect:/board/list";
    }

}
