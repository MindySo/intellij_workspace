package kr.co.jhta.app.springbootex13.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class BoardAttatchedFileDTO {
    private int fileNo;
    private String fileName;
    private String filePath;
    private Long boardNo;
}
