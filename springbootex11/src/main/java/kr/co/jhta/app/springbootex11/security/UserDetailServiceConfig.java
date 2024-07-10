package kr.co.jhta.app.springbootex11.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

//@Configuration
//@RequiredArgsConstructor
//public class UserDetailServiceConfig {
//    private final PasswordEncoder passwordEncoder;
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//
//        manager.createUser(User.withUsername("user")    // 이름은 user
////                .password("{noop}tiger")    // 비밀번호는 암호화되어있지 않은 tiger
//                .password(passwordEncoder.encode("tiger"))  // 암호화된 tiger
//                .roles("USER")  // USER 롤을 가지고 있다.
//                .build());  // 사용자를 생성
//
//        manager.createUser(User.withUsername("admin")
////                .password("{noop}admin")
//                .password(passwordEncoder.encode("admin"))
//                .roles("ADMIN")
//                .build());
//
//        return manager;
//    }
//}
