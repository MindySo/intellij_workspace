package kr.co.jhta.web.service;

import kr.co.jhta.web.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    public List<BoardDTO> readAll(int startNo, int endNo);
    public void write(BoardDTO dto);
    public BoardDTO readOne(int bno);
    public void dropOne(int bno);
    public void updateOne(BoardDTO dto);
    public int getTotal();
}
