package kr.co.jhta.app.springbootex09.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "member")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Member {
    @Id
    @GeneratedValue
    private Integer no;
    @Column(length = 50)
    private String id;
    @Column(length = 100)
    private String pw;
    private String name;
    private String gender;
    private String motive;
    private String email;
}
