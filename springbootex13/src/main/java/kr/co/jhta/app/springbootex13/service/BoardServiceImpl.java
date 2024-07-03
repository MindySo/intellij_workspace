package kr.co.jhta.app.springbootex13.service;

import kr.co.jhta.app.springbootex13.dao.BoardAttatchedDAO;
import kr.co.jhta.app.springbootex13.dao.BoardDAO;
import kr.co.jhta.app.springbootex13.dto.BoardAttatchedFileDTO;
import kr.co.jhta.app.springbootex13.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardServiceImpl implements BoardService{
    private final BoardDAO dao;
    private final BoardAttatchedDAO bdao;

    @Value("${file.upload-dir}")
    private String uploadDirectory;
//    private static final String UPLOAD_DIR = "d:\\dev\\data2";




    @Override
    public List<BoardDTO> getList(int startNo, int endNo) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("startNo", startNo);
        map.put("endNo", endNo);
        List<BoardDTO> list = dao.getAll(map);
        return list;
    }



    @Override
    public void register(BoardDTO dto, MultipartFile[] files) {
        System.out.println("db 저장 전 dto : " + dto.toString());
        dao.addOne(dto);
        System.out.println("db 저장 후 시퀀스 값" + dto.getBno());

        System.out.println("files : " + files);
        System.out.println("저장 디렉토리 : " + uploadDirectory);
        File uploadDir = new File(uploadDirectory);

        if(!uploadDir.exists()){
            uploadDir.mkdirs();
        }

        Arrays.asList(files).forEach(file -> {
            String fileFullName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
            String filePath = uploadDirectory + "/" + fileFullName;
            File dest = new File(filePath);

            try {
                file.transferTo(dest);
                BoardAttatchedFileDTO bdto = new BoardAttatchedFileDTO();
                bdto.setFilePath(fileFullName);
                bdto.setFileName(file.getOriginalFilename());

                bdto.setBoardNo(dto.getBno());
                bdao.addOne(bdto);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    public BoardDTO readOne(Long no) {
        BoardDTO dto = dao.readOne(no);
        return dto;
    }

    @Override
    public void modify(BoardDTO dto) {
        dao.modifyOne(dto);
    }

    @Override
    public void delete(Long no) {
        dao.deleteOne(no);
    }

    @Override
    public int getTotal() {
        int totalNum = dao.getTotal();
        return totalNum;
    }

    @Override
    public int getTotalByKeyword(String keyword) {
        int totalNum = dao.getTotalByKeyword(keyword);
        return totalNum;
    }

    @Override
    public List<BoardDTO> getAllByKeyword(int startNo, int endNo, String keyword) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("startNo", startNo);
        map.put("endNo", endNo);
        map.put("keyword", keyword);
        List<BoardDTO> list = dao.getAllByKeyword(map);
        return list;
    }

    @Override
    public List<BoardAttatchedFileDTO> readFiles(Long bno) {

        return bdao.getList(bno);
    }


//    private final BoardRepository boardRepository;
//    private final BoardAttatchedFileRepository boardAttatchedFileRepository;
//
//    @Value("${file.upload-dir}")
//    private String uploadDirectory;
////    private static final String UPLOAD_DIR = "d:\\dev\\data2";
//
//    @Override
//    public Long register(BoardDTO dto, MultipartFile[] files) {
//        Board b = new Board();
//        b.setTitle(dto.getTitle());
//        b.setContents(dto.getContents());
//        b.setWriter(dto.getWriter());
//        b.setRegDate(LocalDateTime.now());
//        b.setIp(dto.getIp());
//        b.setHits(0);
//        b.setStatus(1);
//
//        System.out.println("files : " + files);
//        System.out.println("저장 디렉토리 : " + uploadDirectory);
//        File uploadDir = new File(uploadDirectory);
//
//        if(!uploadDir.exists()){
//            uploadDir.mkdirs();
//        }
//
//        Arrays.asList(files).forEach(file -> {
//            String fileFullName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
//            String filePath = uploadDirectory + "/" + fileFullName;
//            File dest = new File(filePath);
//
//            try {
//                file.transferTo(dest);
//
//                BoardAttatchedFile bfile = new BoardAttatchedFile();
//                bfile.setBoard(b);
//                bfile.setFilePath(fileFullName);
//                bfile.setFileName(file.getOriginalFilename());
//                boardAttatchedFileRepository.save(bfile);
//
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        });
//
//        Board saved = boardRepository.save(b);
//        return saved.getBno();
//    }
//
//    @Override
//    public Page<Board> getList(int page, String keyword) {
//
//        Pageable pageable = PageRequest.of(page, 10, Sort.by("bno").descending());
//        Page<Board> list = null;
//
//        if(keyword.equals("none")){
//            list = boardRepository.findAll(pageable);
//        }else {
//            list = boardRepository.findAllLikeKeyword(keyword, pageable);
//        }
//        return list;
//
//    }
//
//    @Override
//    public Board readOne(Long no) {
//        Optional<Board> result = boardRepository.findById(no);
//        Board board = null;
//        if(result.isPresent()){
//            board =  result.get();
//        }
//        return board;
//    }
//
//    @Override
//    public void modify(BoardDTO dto) {
//        Board entity = dto.toEntity();
//        boardRepository.save(entity);
//    }
//
//    @Override
//    public void delete(Long no) {
//        Optional<Board> result = boardRepository.findById(no);
//        Board board = null;
//        if(result.isPresent()){
//            board =  result.get();
//        }
//        boardRepository.delete(board);
//    }
}
