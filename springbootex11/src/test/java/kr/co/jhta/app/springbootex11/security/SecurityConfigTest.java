package kr.co.jhta.app.springbootex11.security;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.regex.MatchResult;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class SecurityConfigTest {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void passwordEncoder() {
        final String password = "tiger";
        final String encodedPassword = passwordEncoder.encode(password);

        // 인코딩 된 패스워드
        log.info("tiger를 인코딩한 값 : {}", encodedPassword);

        boolean MatchResult = passwordEncoder.matches(password, encodedPassword);
        log.info("매칭 결과 {} " + MatchResult);
        assertTrue(MatchResult);
    }
}