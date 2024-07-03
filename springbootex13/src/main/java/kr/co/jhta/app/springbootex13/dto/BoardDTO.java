package kr.co.jhta.app.springbootex13.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDTO {
    private Long bno;
    private String writer;
    private String title;
    private String contents;
    private LocalDateTime regDate;
    private int hits;
    private String ip;
    private int status;

//    public Board toEntity() {
//        Board board = new Board();
//        board.setBno(bno);
//        board.setWriter(writer);
//        board.setTitle(title);
//        board.setContents(contents);
//        board.setRegDate(regDate);
//        board.setHits(hits);
//        board.setIp(ip);
//        board.setStatus(status);
//        return board;
//    }
}
