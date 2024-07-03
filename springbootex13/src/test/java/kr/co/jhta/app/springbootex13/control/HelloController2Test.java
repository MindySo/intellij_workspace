package kr.co.jhta.app.springbootex13.control;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HelloController2.class)
class HelloController2Test {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHi() throws Exception {
        mockMvc.perform(get("/hi"))
                .andExpect(status().isOk())
                .andExpect(view().name("welcome"))
                .andExpect(model().attribute("msg", "장마가 계속"))
                .andDo(print());
    }

}