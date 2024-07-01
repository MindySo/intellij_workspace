package kr.co.jhta.app.springbootex12.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter @Getter
@ToString
public class Dept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer deptno;

    private String dname;
    private String loc;
}
