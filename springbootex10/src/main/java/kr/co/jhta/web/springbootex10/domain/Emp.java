package kr.co.jhta.web.springbootex10.domain;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
@ToString
public class Emp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long empno;
    private String ename;
    private String job;
    private Long mgr;
    private LocalDate hiredate;
    private Long sal;
    private Long comm;

    @ManyToOne
    @JoinColumn(name = "deptno")
    private Dept deptno;

}
