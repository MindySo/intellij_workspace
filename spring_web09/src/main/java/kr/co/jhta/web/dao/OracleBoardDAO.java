package kr.co.jhta.web.dao;

import kr.co.jhta.web.dto.BoardDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

// @component : Spring이 관리해라(범용적)
// @Repository : component와 기능은 같음, db와 직접 연결된경우
@Repository
public class OracleBoardDAO implements CommonDAO{

    @Autowired
    private SqlSession ss;

    @Override
    public List<BoardDTO> selectAll() {

        System.out.println("ss : " + ss);
//        ss.selectList("별칭 ==> 네임스페이스명.id");
        return ss.selectList("kr.co.jhta.board.selectAll");
    }

    @Override
    public void insertOne(BoardDTO dto) {
        ss.insert("kr.co.jhta.board.insertOne", dto);
    }

    @Override
    public BoardDTO selectOne(int bno) {
        return ss.selectOne("kr.co.jhta.board.selectOne", bno);
    }

    @Override
    public void delete(int bno) {
        ss.delete("kr.co.jhta.board.delete", bno);
    }
}
