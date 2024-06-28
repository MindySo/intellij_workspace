package kr.co.jhta.app.springbootex11.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter @Setter
@Builder
public class BoardDTO {
    private Long bno;
    private String writer;
    private String title;
    private String contents;
    private LocalDateTime regdate;
    private Long hits;
    private String ip;
    private Long status;
}
