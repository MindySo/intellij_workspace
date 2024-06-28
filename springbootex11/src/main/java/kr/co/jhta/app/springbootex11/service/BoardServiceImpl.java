package kr.co.jhta.app.springbootex11.service;

import kr.co.jhta.app.springbootex11.domain.Board;
import kr.co.jhta.app.springbootex11.dto.BoardDTO;
import kr.co.jhta.app.springbootex11.repository.BoardRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;

    @Override
    public Long register(BoardDTO dto) {

        Board b = new Board();
        b.setTitle(dto.getTitle());
        b.setContents(dto.getContents());
        b.setWriter(dto.getWriter());
        b.setRegdate(LocalDateTime.now());
        b.setIp(dto.getIp());
        b.setHits(0L);
        b.setStatus(1L);
        Board saved = boardRepository.save(b);
        return saved.getBno();
    }

    @Override
    public List<Board> getList(){
        List<Board> list = boardRepository.findAll();

        return list;
    }

    @Override
    public Board get(Long bno) {
        Optional<Board> optional = boardRepository.findById(bno);
        Board board = new Board();
        if (optional.isPresent()) {
            board = optional.get();
        }
        return board;
    }

    @Override
    public void delete(Long bno) {
        Optional<Board> optional = boardRepository.findById(bno);
        if (optional.isPresent()) {
            boardRepository.delete(optional.get());
        }
    }

    @Override
    public void update(BoardDTO dto) {
        Optional<Board> optional = boardRepository.findById(dto.getBno());
        if (optional.isPresent()) {
            Board b = optional.get();
            b.setTitle(dto.getTitle());
            b.setContents(dto.getContents());
            b.setWriter(dto.getWriter());

            boardRepository.save(b);
        }
    }
}
