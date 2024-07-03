package kr.co.jhta.app.springbootex13.control;

// MVC 기능이 잘 동작하는지 확인

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// HelloController 클래스를 테스트
@WebMvcTest(HelloController.class)
class HelloControllerTest {
    // MockMVC 객체를 선언
    @Autowired
    private MockMvc mockMvc;

   // spring boot의 테스트 어노테이션.
   // 전체 애플리케이션 컨텍스를 시작하지 않고
   // MVC 컴포넌트에만 집중하여 웹 레이어를 테스트함

    @DisplayName("/hello 응답테스트")
    @Test
    public void testHello() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello java world"));
    }

}