package kr.co.jhta.web.spring_web_quiz01.control;

public interface CommonDAO {
    public boolean findByIdAndPw(String id, String pw);
    public boolean insertOne(MemberDTO dto);
}
