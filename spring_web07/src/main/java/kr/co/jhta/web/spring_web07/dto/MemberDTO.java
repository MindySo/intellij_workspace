package kr.co.jhta.web.spring_web07.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private int no;
    private String id;
    private String pw;
    private String name;
    private String gender;
    private String motive;

}
