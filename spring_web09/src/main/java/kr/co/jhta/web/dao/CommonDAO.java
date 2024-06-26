package kr.co.jhta.web.dao;

import kr.co.jhta.web.dto.BoardDTO;

import java.util.List;

public interface CommonDAO {
    public List<BoardDTO> selectAll(int startNo, int endNo);
    public void insertOne(BoardDTO dto);
    public BoardDTO selectOne(int bno);
    public void delete(int bno);
    public void update(BoardDTO dto);
    public int getTotal();
}
