package kr.co.jhta.app.springbootex08.repository;

import kr.co.jhta.app.springbootex08.entity.Dept;
import kr.co.jhta.app.springbootex08.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DeptRepositoryTest {
    @Autowired
    DeptRepository DeptRepository;

    @Autowired
    private DeptRepository deptRepository;

    @Test
    public void testClass() {
        System.out.println("DeptRepository >>>>>>>>>>>>>>>>>>"
                + DeptRepository.getClass().getName());
    }

    @Test
    public void testInsert() {
        Dept d1 = Dept.builder()
                .dname("부서")
                .loc("서울")
                .build();
        deptRepository.save(d1);
    }

    @Test
    public void testSelect(){
        Integer deptno = 2;
        Optional<Dept> result = deptRepository.findById(deptno);
        if(result.isPresent()){
            Dept dept = result.get();
            System.out.println(">>>>>>>>>>>>>>>>" + dept.getDname());
        }
    }


    @Test
    public void testUpdate() {
        Dept dept = Dept.builder().deptno(2).dname("부서부서").build();
        System.out.println(deptRepository.save(dept));
    }

    @Test
    public void testDelete() {
        Integer deptno = 2;
        deptRepository.deleteById(deptno);
    }

}