package kr.co.jhta.app.springbootex11.service;

import kr.co.jhta.app.springbootex11.domain.Board;
import kr.co.jhta.app.springbootex11.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    Long register(BoardDTO dto);
    List<Board> getList();
    Board get(Long bno);
    void delete(Long bno);
    void update(BoardDTO dto);
}
