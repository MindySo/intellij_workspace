package kr.co.jhta.web.springbootex10.repository;

import kr.co.jhta.web.springbootex10.domain.Dept;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DeptRepositoryTest {

    @Autowired
    DeptRepository deptRepository;

    @Test
    void testFindById() {
//        Optional은 null 검사를 위한 dept를 담고있는 객체
//        null을 거를 수 있다.
        Optional<Dept> result = deptRepository.findById(10L);
        if (result.isPresent()) {
            Dept dept = result.get();
            System.out.println(dept);
        }
    }


}