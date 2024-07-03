package kr.co.jhta.app.springbootex13.service;

import kr.co.jhta.app.springbootex13.dto.BoardAttatchedFileDTO;
import kr.co.jhta.app.springbootex13.dto.BoardDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BoardService {
    List<BoardDTO> getList(int startNo, int endNo);

    void register(BoardDTO dto, MultipartFile[] files);

    BoardDTO readOne(Long no);

    void modify(BoardDTO dto);

    void delete(Long no);

    int getTotal();

    int getTotalByKeyword(String keyword);

    List<BoardDTO> getAllByKeyword(int startNo, int endNo, String keyword);

    List<BoardAttatchedFileDTO> readFiles(Long bno);


//    Long register(BoardDTO dto, MultipartFile[] files);
//
//    Page<Board> getList(int page, String keyword);
//
//    Board readOne(Long no);
//
//    void modify(BoardDTO dto);
//
//    void delete(Long no);
}
