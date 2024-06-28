package kr.co.jhta.web.springbootex10.repository;

import jakarta.transaction.Transactional;
import kr.co.jhta.web.springbootex10.domain.Dept;
import kr.co.jhta.web.springbootex10.domain.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
//@Transactional
public class FetchTest {
    @Autowired
    private EmpRepository empRepository;

    @Autowired
    private DeptRepository deptRepository;

    @Test
    public void test() {
        //초기 데이터 삽입
        //부서 1 경영 서울, 부서 2 IT 부산
        Dept d1 = new Dept();
        d1.setDname("경영");     // Entity : setter 가급적 X, 개발자의 의도가 보이지 않기 때문에
        d1.setLoc("서울");
        Dept d2 = new Dept();
        d2.setDname("IT");     // Entity : setter 가급적 X, 개발자의 의도가 보이지 않기 때문에
        d2.setLoc("부산");

            deptRepository.save(d1);
            deptRepository.save(d2);
        for(int i = 0 ; i < 10 ; i++) {
            Emp e = new Emp();
            e.setEname("뽀로로" + i);
            e.setJob("백수");
            e.setDept(d1);
            empRepository.save(e);

            Emp e2 = new Emp();
            e2.setEname("보노보노" + i);
            e2.setJob("수달");
            e2.setDept(d2);
            empRepository.save(e2);
        }

        List<Emp> emps = empRepository.findAll();
        for(Emp emp : emps) {
            System.out.println("부서명 : " + emp.getDept());
        }
        System.out.println("-----------------------------------------------");
        Dept dept = empRepository.getDeptEmpno(1L);
        System.out.println(dept);


        // 해당 부서에 근무하는 사원 10명씩 추가
    }

}
