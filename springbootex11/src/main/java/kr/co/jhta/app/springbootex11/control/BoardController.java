package kr.co.jhta.app.springbootex11.control;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.jhta.app.springbootex11.domain.Board;
import kr.co.jhta.app.springbootex11.dto.BoardDTO;
import kr.co.jhta.app.springbootex11.repository.BoardRepository;
import kr.co.jhta.app.springbootex11.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("msg", "hello");

        // 전체 목록을 가지고 전달
        // 서비스 인터페이스에서 추가
        // 서비스 구현클래스에서 추가
        // 가져오기
        // 뷰로 전달
        // 뷰 값을 받아서 th:each

        List<Board> list = boardService.getList();
        model.addAttribute("list", list);
        return "board/list";
    }

    @GetMapping("/write")
    public String write(Model model) {
        return "board/writeForm";
    }

    @PostMapping("/write")
    public String write(@ModelAttribute BoardDTO dto, HttpServletRequest request) {
        log.info("전달받은 dto : " + dto.toString());
        dto.setIp(request.getRemoteAddr());
        Long registered = boardService.register(dto);
        log.info("등록된 게시물 번호 {} : ", registered);
        return "redirect:/board/list";
    }

    @GetMapping("/detail/{bno}")
    public String detail(@PathVariable Long bno, Model model) {
        Board board = boardService.get(bno);
        model.addAttribute("board", board);
        return "board/detail";
    }

    @GetMapping("/delete/{bno}")
    public String delete(@PathVariable Long bno, Model model) {
        boardService.delete(bno);
        return "redirect:/board/list";
    }

    @GetMapping("/modify/{bno}")
    public String update(@PathVariable Long bno, Model model) {
        Board board = boardService.get(bno);
        model.addAttribute("board", board);
        return "board/updateForm";
    }

    @PostMapping("/modify/{bno}")
    public String update(@ModelAttribute BoardDTO dto, HttpServletRequest request) {
        boardService.update(dto);
        return "redirect:/board/list";
    }
}
