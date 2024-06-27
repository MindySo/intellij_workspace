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
    // 아무것도 쓰지 않으면 default
    @GeneratedValue
        // 지정해 줄 수도 있다
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_no_seq")
//    @SequenceGenerator(name = "member_no_seq", sequenceName = "member_no_seq", allocationSize = 1, initialValue = 1)
//    @GeneratedValue(strategy = GenerationType.TABLE)
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
