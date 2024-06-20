package kr.co.jhta.web.spring_web08;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UploadController {
    @Autowired
    FileDAO dao;

    @GetMapping("/upload.do")
    public String upload() {
        return "uploadForm";
    }

    @GetMapping("/filelist.do")
    public String filelist(Model model) {
        List<FileDTO> list = dao.selectAll();
        model.addAttribute("list", list);
        return "filelist";
    }
}
