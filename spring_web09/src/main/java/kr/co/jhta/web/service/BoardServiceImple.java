package kr.co.jhta.web.service;

import kr.co.jhta.web.dao.CommonDAO;
import kr.co.jhta.web.dto.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

// @component : Spring이 관리해라(범용적)
// @Repository : component와 기능은 같음, db와 직접 연결된경우
// @("연결할 DB") : DB가 여러개일 경우 명시해줘야 함
@Service("oracleService")
public class BoardServiceImple implements BoardService {

    @Autowired
            @Qualifier("oracleDB")
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
