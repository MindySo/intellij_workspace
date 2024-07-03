package kr.co.jhta.app.springbootex13.dao;

import kr.co.jhta.app.springbootex13.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@Mapper
public interface BoardDAO {
    List<BoardDTO> getAll(HashMap<String, Integer> map);

    int addOne(BoardDTO dto);

    BoardDTO readOne(Long no);

    void modifyOne(BoardDTO dto);

    void deleteOne(Long no);

    int getTotal();

    int getTotalByKeyword(String keyword);

    List<BoardDTO> getAllByKeyword(HashMap<String, Object> map);

    int selectSequence();
}
