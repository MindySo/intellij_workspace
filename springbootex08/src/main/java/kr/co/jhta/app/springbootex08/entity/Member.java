package kr.co.jhta.app.springbootex08.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "member")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "no")
    private Long no;
    private String id;
    private String pw;
    private String name;
    private String gender;
    private String motive;
    private String email;

}
