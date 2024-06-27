package kr.co.jhta.web.springbootex10.repository;

import kr.co.jhta.web.springbootex10.domain.Dept;
import kr.co.jhta.web.springbootex10.domain.Emp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptRepository extends JpaRepository<Dept, Long> {
    Dept findByDeptno(long deptno);

}
