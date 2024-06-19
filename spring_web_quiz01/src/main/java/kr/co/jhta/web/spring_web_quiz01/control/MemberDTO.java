package kr.co.jhta.web.spring_web_quiz01.control;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    private int no;
    private String id;
    private String pw;
    private String name;
    private String gender;
    private String motive;

}
