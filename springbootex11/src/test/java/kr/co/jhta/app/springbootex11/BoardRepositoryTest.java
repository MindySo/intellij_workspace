package kr.co.jhta.app.springbootex11;

import jakarta.persistence.Entity;
import kr.co.jhta.app.springbootex11.domain.Board;
import kr.co.jhta.app.springbootex11.repository.BoardRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardRepositoryTest {
    @Autowired
    private BoardRepository boardRepository;

    @DisplayName("1건 추가 후 확인")
    @Test
    void test_newdata(){
        Board board = new Board();
        board.setWriter("홍길동");
        board.setTitle("금요일");
        board.setContents("월화수목금");
        boardRepository.save(board);
    }
}
