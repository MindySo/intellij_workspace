package kr.co.jhta.web.springbootex10.repository;

import kr.co.jhta.web.springbootex10.domain.Dept;
import kr.co.jhta.web.springbootex10.domain.Emp;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DeptRepositoryTest {

    @Autowired
    DeptRepository deptRepository;
    @Autowired
    private EmpRepository empRepository;
    @Autowired
    private DispatcherServlet dispatcherServlet;

//    @Test
//    void testFindById() {
////        Optional은 null 검사를 위한 dept를 담고있는 객체
////        null을 거를 수 있다.
//        Optional<Dept> result = deptRepository.findById(10L);
//        if (result.isPresent()) {
//            Dept dept = result.get();
//            System.out.println(dept);
//        }
//    }

    // 새로운 데이터 생성
    @DisplayName("새로운 데이터 생성")
    @Test
    @Order(1)
    public void test_newdata(){
        Dept dept = new Dept();
        dept.setDname("RE100");
        dept.setLoc("서울");
        deptRepository.save(dept);

        Emp emp1 = new Emp();
        emp1.setEname("뽀로로");
        emp1.setSal(1000);
        emp1.setComm(0L);
        emp1.setJob("MANAGER");
        empRepository.save(emp1);
        //--------------------------------------------
        Emp emp2 = new Emp();
        emp2.setEname("둘리");
        emp2.setSal(1000);
        emp2.setComm(0L);
        emp2.setJob("MANAGER");
        empRepository.save(emp2);
        //--------------------------------------------
        Emp emp3 = new Emp();
        emp3.setEname("타요");
        emp3.setSal(1000);
        emp3.setComm(0L);
        emp3.setJob("MANAGER");
        empRepository.save(emp3);
        //--------------------------------------------
    }

    @DisplayName("1번 부서의 정보 가져오기")
    @Test
    @Order(2)
    void test_find1(){
        Dept dept = deptRepository.findById(1L).get();
        assertNotNull(dept);
        log.info("dept: {}", dept.toString());

        List<Emp> empList = dept.getEmpList();
        assertNotNull(empList);
        empList.forEach(emp -> {
            System.out.println(emp.getEmpno() + " : " + emp.getEname() + " : " + emp.getSal());
        });
    }

    @DisplayName("둘리 수정")
    @Test
    @Order(4)
    void test_update2(){
        // 1번 부서에 근무하는 둘리의 월급을 1500으로 변경
        Optional<Dept> result = deptRepository.findById(1L);

        if(result.isPresent()){
            Dept dept = result.get();
            List<Emp> empList = dept.getEmpList();
            for(Emp e : empList){
                if(e.getEname().equals("둘리")){
                    e.setSal(1500);
                    empRepository.save(e);
                }
                System.out.println(e.getEmpno() + " : " + e.getEname() + " : " + e.getSal());
            }
        }
    }

    @DisplayName("1번 부서번호를 10으로 변경")
    @Test
    @Order(4)
    void testUpdateDeptNo() {
        Dept dept = deptRepository.findById(1L).orElse(null);
        dept.setDeptno(10L);
        deptRepository.save(dept);
    }

    @DisplayName("모든 사원들의 부서번호 2로 변경")
    @Test
    @Order(5)
    void test_empUpdate() {
       Dept d = new Dept();
       d.setDeptno(1L);
       List<Emp> result2 = empRepository.findByDept(d);
       log.info("result: {}", result2);
       result2.forEach(emp ->{
           System.out.println(emp.getEmpno() + " : " + emp.getEname() + " : " + emp.getSal());
           Dept dept = new Dept();
           dept.setDeptno(2L);
           emp.setDept(dept);
           empRepository.save(emp);
       });
    }

    @DisplayName("2번 부서를 삭제")
    @Test
    @Order(6)
    void test_delete() {
        deptRepository.deleteById(2L);
        Optional<Dept> result = deptRepository.findById(2L);
        assertTrue(result.isEmpty());
    }



//    @Test
//    void test_newdata2(){
//        Emp emp = new Emp();
//        emp.setEname("뽀로로");
//        emp.setSal(1000L);
//        emp.setComm(0L);
//        emp.setJob("MANAGER");
//        empRepository.save(emp);
//    }





}