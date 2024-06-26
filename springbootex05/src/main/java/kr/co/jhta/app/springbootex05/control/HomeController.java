package kr.co.jhta.app.springbootex05.control;

import kr.co.jhta.app.springbootex05.dto.DeptDTO;
import kr.co.jhta.app.springbootex05.dto.SampleDTO;
import org.springframework.ui.Model;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j  // (sout 대신) log 사용하기
@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/ex1")
    public void ex1(Model model) {
        log.info("ex1 >>>>>>>>>>>>>>>>>>>>");
        model.addAttribute("title", "thymeleaf ex1");
    }

    @GetMapping("/ex2")
    public void ex2(Model model) {
        List<SampleDTO> list = new ArrayList<>();

        // 빌더를 사용해서
        // 1, scott, tiger, 현재시간 으로 dto 생성

        // 을 list에 10개 담기

//        for(Long i = 1L ; i < 10L ; i++){
//            SampleDTO dto = SampleDTO.builder()
//                    .sno(i)
//                    .first("scott" + i)
//                    .last("tiger" + i)
//                    .regtime(LocalDateTime.now()).build();
//            list.add(dto);
//        }

        IntStream.rangeClosed(1, 20).asLongStream().mapToObj( i ->
        { SampleDTO dto = SampleDTO.builder().sno(i)
                                            .first("scott" + i)
                                            .last("tiger" + i)
                                            .regTime(LocalDateTime.now()).build();
        return dto;}).collect(Collectors.toList());

        

        model.addAttribute("list", list);
        model.addAttribute("name", "홍길동");
        log.info("ex2 >>>>>>>>>>>>>>>>>>>");
    }

    @GetMapping("/ex3")
    public void ex3(Model model) {
        // ex3 ===(test())====> ex3.html
        // "홍길동", "이순신", "둘리"
        // li로 출력

        List<String> list = Arrays.asList("홍길동", "이순신", "둘리");
        model.addAttribute("list", list);

    }

    @GetMapping("/ex4")
    public void ex4(Model model) {
        List<Integer> list = new ArrayList<>();
        Random rnd = new Random();
        for(int i = 1; i <= 5; i++) {
            list.add(rnd.nextInt(100));
        }
        model.addAttribute("list", list);
    }

    @GetMapping("/ex5")
    public void ex5(Model model) {
        model.addAttribute("msg1", "<b>Spring<b>");
    }

    @GetMapping("/ex6")
        public void ex6(Model model) {
            SampleDTO dto1 = SampleDTO.builder()
                    .sno(1L)
                    .first("scott")
                    .last("tiger")
                    .regTime(LocalDateTime.now())
                    .build();
            
            SampleDTO dto2 = SampleDTO.builder()
                    .sno(2L)
                    .first("scott")
                    .last("tiger")
                    .regTime(LocalDateTime.now())
                    .build();
            
            // object를 저장해서 전달
            ArrayList<SampleDTO> alist = new ArrayList<>();
            alist.add(dto1);
            alist.add(dto2);

            Map<String, SampleDTO> map = new HashMap<>();
            map.put("dto1", dto1);
            map.put("dto2", dto2);

            model.addAttribute("dto1", dto1);
            model.addAttribute("alist", alist);
            model.addAttribute("map", map);
    }

    @GetMapping("/ex7")
    public void ex7(Model model) {
        String param1 = "hello";
        String param2 = "world";
        model.addAttribute("param1", param1);
        model.addAttribute("param2", param2);
    }

    @GetMapping("/ex8")
    public void ex8(Model model) {
        model.addAttribute("nullvalue", null);
        model.addAttribute("data", "thymeleaf");

    }

    @GetMapping("/ex9")
    public void ex9(Model model) {
        DeptDTO dto1 = new DeptDTO(10, "IT", "서울");
        DeptDTO dto2 = DeptDTO.builder().deptno(20).dname("AI").loc("부산").build();
        DeptDTO dto3 = DeptDTO.builder().deptno(30).dname("경영").loc("서울").build();
        DeptDTO dto4 = DeptDTO.builder().deptno(40).dname("회계").loc("울산").build();

        log.info("dto3 : " + dto3);
        dto3 = dto3.toBuilder().loc("하이퐁").build();
        log.info("dto3 : " + dto3);

        ArrayList<DeptDTO> dList = new ArrayList<>();
        dList.add(dto1);
        dList.add(dto2);
        dList.add(dto3);
        dList.add(dto4);

        model.addAttribute("dList", dList);
        model.addAttribute("dto4", dto4);

    }

}
