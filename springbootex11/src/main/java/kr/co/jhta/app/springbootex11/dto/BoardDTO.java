package kr.co.jhta.app.springbootex11.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import kr.co.jhta.app.springbootex11.domain.Board;
import kr.co.jhta.app.springbootex11.repository.BoardRepository;
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

    @NotEmpty(message = "작성자는 필수 입력 항목입니다.")
    @Size(max=10, message = "작성자는 10자 이내여야 합니다.")
    private String writer;

    @NotEmpty(message = "제목은 필수 입력 항목입니다.")
    @Size(max = 10, message = "제목은 10자 이내여야 합니다.")
    private String title;

    @NotEmpty(message = "내용은 필수 입력 항목입니다.")
    private String contents;

    private LocalDateTime regDate;
    private int hits;
    private String ip;
    private int status;

    public Board toEntity() {
        Board board = new Board();
        board.setBno(bno);
        board.setWriter(writer);
        board.setTitle(title);
        board.setContents(contents);
        board.setRegDate(regDate);
        board.setHits(hits);
        board.setIp(ip);
        board.setStatus(status);
        return board;
    }
}
