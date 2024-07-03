package kr.co.jhta.app.springbootex13.control;

import kr.co.jhta.app.springbootex13.service.HelloService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class HelloController3Test {
    @Autowired
    private MockMvc mvc;

//    @Autowired
    // @MockBean을 사용하여 HelloService를 모킹합니다.
    // 이렇게 하면 실제 HelloServiceImple 대신 모킹된 HelloService가 주입
    @MockBean   // 객체가 있는 것처럼
    private HelloService helloService;

    @Test
//    @Disabled   //검사 비활성
    public void testHello() throws Exception {
        // 흉내내는 객체는 sayHello()를 호출하면 ~~라는 문자를 리턴하도록
        Mockito.when(helloService.sayHello()).thenReturn("안녕 둘리");

        mvc.perform(get("/sayHi"))
                    .andExpect(status().isOk())
                    .andExpect(content().string("안녕 둘리"))
                    .andDo(print());
        System.out.println("helloService : " + helloService);
    }

}