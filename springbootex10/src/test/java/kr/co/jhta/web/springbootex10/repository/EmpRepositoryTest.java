package kr.co.jhta.web.springbootex10.repository;

import kr.co.jhta.web.springbootex10.domain.Dept;
import kr.co.jhta.web.springbootex10.domain.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmpRepositoryTest {

    @Autowired
    EmpRepository empRepository;

    @Test
    public void testFindById(){
        Optional<Emp> result = empRepository.findById(7788L);
        if(result.isPresent()){
            Emp emp = result.get();
            System.out.println(emp);
            Dept dept = emp.getDeptno();
            System.out.println(dept.getDname() + " : " + dept.getLoc());
        }
    }



}