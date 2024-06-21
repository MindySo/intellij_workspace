package kr.co.jhta.web.dao;

import kr.co.jhta.web.dto.BoardDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository("mysqlDB")
public class MySQLBoardDAO implements CommonDAO{

    @Autowired
    private SqlSession ss;

    @Override
    public List<BoardDTO> selectAll(int startNo, int endNo) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("startNo", startNo);
        map.put("endNo", endNo);

        System.out.println("ss : " + ss);
//        ss.selectList("별칭 ==> 네임스페이스명.id");
        return ss.selectList("kr.co.jhta.boardMySQL.selectAll", map);
    }

    @Override
    public void insertOne(BoardDTO dto) {
        ss.insert("kr.co.jhta.boardMySQL.insertOne", dto);
    }

    @Override
    public BoardDTO selectOne(int bno) {
        return ss.selectOne("kr.co.jhta.boardMySQL.selectOne", bno);
    }

    @Override
    public void delete(int bno) {
        ss.delete("kr.co.jhta.boardMySQL.delete", bno);
    }

    @Override
    public void update(BoardDTO dto) {
        ss.update("kr.co.jhta.boardMySQL.update", dto);
    }

    @Override
    public int getTotal() {
        return ss.selectOne("kr.co.jhta.boardMySQL.getTotal");
    }
}
