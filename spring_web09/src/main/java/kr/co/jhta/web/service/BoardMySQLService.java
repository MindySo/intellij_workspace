package kr.co.jhta.web.service;

import kr.co.jhta.web.dao.CommonDAO;
import kr.co.jhta.web.dto.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;
import java.util.List;

@Service("mysqlService")
public class BoardMySQLService implements BoardService {
    @Autowired
            @Qualifier("mysqlDB")
    CommonDAO dao;

    @Override
    public List<BoardDTO> readAll(int startNo, int endNo) {
        return dao.selectAll(startNo, endNo);
    }

    @Override
    public void write(BoardDTO dto) {
        dao.insertOne(dto);
    }

    @Override
    public BoardDTO readOne(int bno) {
        return dao.selectOne(bno);
    }

    @Override
    public void dropOne(int bno) {
        dao.delete(bno);
    }

    @Override
    public void updateOne(BoardDTO dto) {
        dao.update(dto);
    }

    @Override
    public int getTotal() {
        return dao.getTotal();
    }
}
