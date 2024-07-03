package kr.co.jhta.app.springbootex13.dao;

import kr.co.jhta.app.springbootex13.dto.BoardAttatchedFileDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BoardAttatchedDAO {
    void addOne(BoardAttatchedFileDTO bdto);

    List<BoardAttatchedFileDTO> getList(Long bno);
}
