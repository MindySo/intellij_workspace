package kr.co.jhta.web.springbootex10.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
@Builder
@ToString
public class Dept {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long deptno;
    private String dname;
    private String loc;
}
