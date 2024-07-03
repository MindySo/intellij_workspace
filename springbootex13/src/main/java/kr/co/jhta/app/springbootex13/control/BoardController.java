package kr.co.jhta.app.springbootex13.control;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.jhta.app.springbootex13.dto.BoardAttatchedFileDTO;
import kr.co.jhta.app.springbootex13.dto.BoardDTO;
import kr.co.jhta.app.springbootex13.service.BoardService;
import kr.co.jhta.app.springbootex13.util.PageUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/list")
    public String list(Model model,
                       @RequestParam(name = "page", defaultValue = "1")int page,
                       @RequestParam(name = "keyword", defaultValue = "none")String keyword) {

        int totalNumber = 0;
        int recordPerPage = 10;
        Map<String, Object> map= null;
        List<BoardDTO> list = null;

        if(keyword.equals("none")){
            //총 게시물 수
            totalNumber = boardService.getTotal();

            //페이지 당 게시물 수
            recordPerPage = 10;

            map = PageUtil.getPageData(totalNumber, recordPerPage, page);

            int startNo = (int)map.get("startNo");
            int endNo = (int)map.get("endNo");
            list = boardService.getList(startNo, endNo);

        }else {
            totalNumber = boardService.getTotalByKeyword(keyword);
            map = PageUtil.getPageData(totalNumber, recordPerPage, page);

            int startNo = (int)map.get("startNo");
            int endNo = (int)map.get("endNo");
            list = boardService.getAllByKeyword(startNo, endNo, keyword);
            model.addAttribute("keyword", keyword);
        }

        model.addAttribute("list", list);
        model.addAttribute("map", map);
        return "board/list";
    }

    @GetMapping("/write")
    public String write(Model model) {
        return "board/writeForm";
    }

    @PostMapping("/write")
    public String write(@ModelAttribute BoardDTO dto, HttpServletRequest request,
                        @RequestParam("fileupload") MultipartFile[] files) {
        log.info("files: {}", files.length);
        log.info("전달받은 dto : " + dto.toString());
        dto.setIp(request.getRemoteAddr());
        boardService.register(dto, files);
        return "redirect:/board/list";
    }


    @GetMapping("/detail/{no}")
    public String detail(@PathVariable Long no, Model model) {
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>> {} ", no);
        BoardDTO dto = boardService.readOne(no);
        // 첨부파일이 있으면 가져오기
        List<BoardAttatchedFileDTO> fileList = boardService.readFiles(dto.getBno());
        System.out.println("fileList : " + fileList.size());
        model.addAttribute("board", dto);
        model.addAttribute("fileList", fileList);
        return "board/detail";
    }

    @GetMapping("/modify")
    public String modify(@RequestParam Long bno, Model model) {
        BoardDTO board = boardService.readOne(bno);
        model.addAttribute("board", board);
        return "board/modifyForm";
    }

    @PostMapping("/modify")
    public String modify(@ModelAttribute BoardDTO dto, HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        dto.setIp(ip);
        dto.setRegDate(LocalDateTime.now());

        boardService.modify(dto);
        return "redirect:/board/list";
    }

    @GetMapping("/delete/{no}")
    public String delete(@PathVariable Long no, Model model) {
        boardService.delete(no);
        log.info(">>>>>>>>>>>>>>>>>>>>>>> {} ", no);
        return "redirect:/board/list";
    }




//    @GetMapping("/list")
//    public String list(Model model,
//                       @RequestParam(value="page", defaultValue = "0") int page,
//                       @RequestParam(value = "keyword", defaultValue = "none")String keyword) {
////        model.addAttribute("msg", "hello");
//        Page<Board> boardPage = boardService.getList(page, keyword);
//        // 전체목록을 가지고 전달
//        // 서비스 인터페이스 에서 추가   getList()
//        // 서비스 구현클래스에서 추가
//        // 가져오기
//        System.out.println("boardPage.getTotalElements() : " + boardPage.getTotalElements());
//        System.out.println(boardPage.getNumberOfElements());
//        System.out.println(boardPage.getNumber());
//
//        // 시작 페이지
//        int startpage = Math.max(0, boardPage.getNumber() - 4);
//
//        // 끝 페이지
//        int endpage = 10;
//        if(startpage > 5) {
//            endpage = Math.min(boardPage.getTotalPages()-1, boardPage.getNumber() + 4);
//        }else{
//            endpage = Math.min(boardPage.getTotalPages()-1, boardPage.getNumber() + 10);
//        }
//
//        model.addAttribute("boardPage", boardPage);
//        model.addAttribute("startpage", startpage);
//        model.addAttribute("endpage", endpage);
//        if(!keyword.equals("none")) {
//            model.addAttribute("keyword", keyword);
//        }
//
//        log.info("boardPage: {}", boardPage);
//        // 뷰로 전달
//        // 뷰에서는 받아온 값을 이용해서 th:each
//        return "board/list";
//    }
//
//    @GetMapping("/write")
//    public String write(Model model) {
//        return "board/writeForm";
//    }
//
//    @PostMapping("/write")
//    public String write(@ModelAttribute BoardDTO dto, HttpServletRequest request,
//                        @RequestParam("fileupload")MultipartFile[] files) {
//        log.info("files: {}", files.length);
//        log.info("전달받은 dto : " + dto.toString());
//        dto.setIp(request.getRemoteAddr());
//        Long registered = boardService.register(dto, files);
//        log.info("등록된게시물번호 {} ",  registered);
//        return "redirect:/board/list";
//    }
//    @GetMapping("/detail/{no}")
//    public String detail(@PathVariable Long no, Model model) {
//        log.info(">>>>>>>>>>>>>>>>>>>>>>>>> {} ", no);
//        Board board = boardService.readOne(no);
//        model.addAttribute("board", board);
//        return "board/detail";
//    }
//
//    @GetMapping("/modify")
//    public String modify(@RequestParam Long bno, Model model ) {
//        Board board = boardService.readOne(bno);
//        model.addAttribute("board", board);
//        return "board/modifyForm";
//    }
//
//    @PostMapping("/modify")
//    public String modify(@ModelAttribute BoardDTO dto, HttpServletRequest request) {
//        String ip = request.getRemoteAddr();
//        dto.setIp(ip);
//        dto.setRegDate(LocalDateTime.now());
//
//        boardService.modify(dto);
//        return "redirect:/board/list";
//    }
//
//    @GetMapping("/delete/{no}")
//    public String delete(@PathVariable Long no, Model model) {
//        boardService.delete(no);
//        log.info(">>>>>>>>>>>>>>>>>>>>>>> {} ", no);
//        return "redirect:/board/list";
//    }
//

}
