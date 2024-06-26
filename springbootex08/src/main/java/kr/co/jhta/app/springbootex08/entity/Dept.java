package kr.co.jhta.app.springbootex08.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Dept")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Dept {
    @Id
    @GeneratedValue
    @Column(name = "deptno")
    private Integer deptno;
    private String dname;
    private String loc;
}
