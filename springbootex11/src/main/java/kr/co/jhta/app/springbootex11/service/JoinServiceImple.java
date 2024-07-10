package kr.co.jhta.app.springbootex11.service;

import kr.co.jhta.app.springbootex11.domain.UserEntity;
import kr.co.jhta.app.springbootex11.dto.JoinDTO;
import kr.co.jhta.app.springbootex11.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinServiceImple implements JoinService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void joinProcess(JoinDTO dto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(dto.getUsername());
        userEntity.setPassword(passwordEncoder.encode(dto.getPassword()));
        userEntity.setRole("ROLE_USER");
        userRepository.save(userEntity);
    }
}
