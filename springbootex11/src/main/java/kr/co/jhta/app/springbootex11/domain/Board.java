package kr.co.jhta.app.springbootex11.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@ToString
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_no_seq")
    @SequenceGenerator(name = "board_no_seq", sequenceName = "board_no_seq", allocationSize = 1, initialValue = 1)
    private Long bno;

    @Column(length = 30, nullable = false)
    private String writer;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 2000, nullable = false)
    private String contents;

    @Column(name = "regdate", updatable = true)
    private LocalDateTime regdate;

    private Long hits;
    private String ip;
    private Long status;

}
