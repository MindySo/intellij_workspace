package kr.co.jhta.app.springbootex09.repository;

import jakarta.transaction.Transactional;
import kr.co.jhta.app.springbootex09.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

//    @Test
//    public void testTotalCount(){
//        List<Member> list = MemberRepository.findAll();
//        System.out.println(list.size());
//    }

    @Test
    public void testFindByName(){
        Pageable pageable = PageRequest.of(0, 10);
        Page<Member> m1 = memberRepository.findByName("aaa", pageable);
        System.out.println(m1.getTotalElements());
        m1.get().forEach(m -> System.out.println(m.getId() + " : " + m.getPw() + " : " + m.getName()));
    }

    @Test
    public void testFindByNo(){
        List<Member> list = memberRepository.findByNoBetweenOrderByNameDesc(102, 106);

    }

    @Test
    @Transactional
    public void testDeleteByNoGreaterThanEqual(){
        System.out.println("107 이상의 데이터는 삭제");
        memberRepository.deleteByNoGreaterThanEqual(107);
    }

    @Test
    public void testFindByNoLessThanEqualAsc(){
        List<Member> list = memberRepository.findByNoLessThanEqual(104);
        list.forEach(m -> System.out.println(m.getId() + " : " + m.getPw() + " : " + m.getName()));
    }

    @Test
    public void testFindByNameContaining(){
        List<Member> list = memberRepository.findByNameContaining("a");
        list.forEach(m -> System.out.println(m.getId() + " : " + m.getPw() + " : " + m.getName()));
    }

    @Test
    public void testJpql(){
        List<Member> list = memberRepository.findMember("e");
        list.forEach(m -> System.out.println(m.getId() + " : " + m.getPw() + " : " + m.getName()));
    }

    @Test
    public void testJpql2(){
        Member member = memberRepository.findMemberByIdAndPw("aaa", "aaa");
        System.out.println(member.getId() + " : " + member.getPw() + " : " + member.getName());
    }

}