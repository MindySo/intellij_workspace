package kr.co.jhta.app.springbootex11.control;

import kr.co.jhta.app.springbootex11.dto.JoinDTO;
import kr.co.jhta.app.springbootex11.repository.UserRepository;
import kr.co.jhta.app.springbootex11.service.JoinService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class JoinController {
    private final JoinService joinService;

    @GetMapping("/join")
    public String join() {
        return "join";
    }

    @PostMapping("/joinProc")
    public void joinProc(JoinDTO dto) {
        log.info("사용자명 : {}, 패스워드 : {}", dto.getUsername(), dto.getPassword());

        // 이런 username을 가진 사람이 있으면 취소 없으면 저장
        boolean existsUser = UserRepository.existsByUsername(dto.getUsername());

        // 더 복잡한 비밀번호
        // 정규표현식
        if (existsUser) {
           return ;
        }

        joinService.joinProcess(dto); // db에 저장
//      return "redirect:/login";
    }


}
