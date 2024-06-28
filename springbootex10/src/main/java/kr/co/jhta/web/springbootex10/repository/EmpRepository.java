package kr.co.jhta.web.springbootex10.repository;

import kr.co.jhta.web.springbootex10.domain.Dept;
import kr.co.jhta.web.springbootex10.domain.Emp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.SQLOutput;
import java.util.List;

public interface EmpRepository extends JpaRepository<Emp,Long> {
    Emp findByEmpno(Long empno);
    List<Emp> findByDept(Dept dept);

    // fetch join : N+1 문제
    @Query("SELECT D FROM Dept D join fetch Emp E ON D.deptno = E.dept.deptno WHERE D.deptno = :deptno")
    Dept getDeptEmpno(Long deptno);

}
