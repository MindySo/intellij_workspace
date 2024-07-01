package kr.co.jhta.app.springbootex11.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "attatched_file")
@Setter
@Getter
public class BoardAttatchedFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer no;
    private String filePath;
    private String fileName;

    @ManyToOne
    @JoinColumn(name = "boardno")
    private Board board;
}
