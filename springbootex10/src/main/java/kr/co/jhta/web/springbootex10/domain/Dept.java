package kr.co.jhta.web.springbootex10.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
@Builder
@ToString(exclude = "empList")
public class Dept {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long deptno;
    private String dname;
    private String loc;

    @OneToMany(mappedBy = "dept", fetch = FetchType.EAGER) //eager: 즉시 로딩, lazy: 필요한 순간에 로딩
    private List<Emp> empList;

}
