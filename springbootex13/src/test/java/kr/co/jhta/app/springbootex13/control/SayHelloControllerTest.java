package kr.co.jhta.app.springbootex13.control;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = SayHelloController.class)
class SayHelloControllerTest {
    @Autowired
    private MockMvc mvc;
    
    @Test
    public void sayHello() throws Exception {
        mvc.perform(get("/sayHello"))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"))
                .andExpect(model().attribute("data", "수요일"))
                .andDo(print());
    }

}