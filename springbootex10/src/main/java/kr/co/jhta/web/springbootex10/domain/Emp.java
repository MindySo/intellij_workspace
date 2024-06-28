package kr.co.jhta.web.springbootex10.domain;


import jakarta.persistence.*;
import lombok.*;

import javax.naming.Name;
import java.time.LocalDate;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
@ToString(exclude = "dept")
public class Emp {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long empno;

    @Column(name = "ename", length = 50, nullable = false)
    private String ename;
    private String job;
    private Long mgr;
    private LocalDate hiredate;

    @Column(name="sal", precision=7, scale=2)
    private int sal;
    private Long comm;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "deptno")
    private Dept dept;

}
