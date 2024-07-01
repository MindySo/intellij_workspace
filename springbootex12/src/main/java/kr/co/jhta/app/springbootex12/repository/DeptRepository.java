package kr.co.jhta.app.springbootex12.repository;


import kr.co.jhta.app.springbootex12.domain.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptRepository extends JpaRepository<Dept, Integer> {

}
