package kr.co.jhta.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name = "p")
    public Printer printMsg(){
        return new LaserPrinter();
    }

}
