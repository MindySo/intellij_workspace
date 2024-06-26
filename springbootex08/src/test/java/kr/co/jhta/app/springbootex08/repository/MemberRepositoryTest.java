package kr.co.jhta.app.springbootex08.repository;

import kr.co.jhta.app.springbootex08.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository MemberRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void testClass(){
        System.out.println("MemberRepository >>>>>>>>>>>> : "
                + MemberRepository.getClass().getName());
    }

    @Test
    public void testInsert(){
        Member m1 = Member.builder()
                .name("KS")
                .gender("남")
                .email("dagda@hanafos.com")
                .motive("친구추천")
                .pw("1234")
                .id("abc")
                .build();

        memberRepository.save(m1);
    }
    @Test
    public void testSelect(){
        Long no = 1L;
        Optional<Member> result =
                memberRepository.findById(no);

        if(result.isPresent()){
            Member m1 = result.get();
            System.out.println(">>>>>>>>>>>>>>>> : " + m1.getName());
        }
    }
//    @DisplayName("다른방식의 조회")
//    @Test
//    public void testSelect2(){
//        Long no = 1L;
//        Member m2 = memberRepository.getOne(no);
//        System.out.println(">>>>>>>>>>>>>>>> : " + m2.getName());
//    }
    @Test
    public void testUpdate(){
        Member member = Member.builder().no(1L).motive("네이버검색").build();
        System.out.println(memberRepository.save(member));

    }

    @Test
    public void testDelete(){
        Long no = 52L;
        memberRepository.deleteById(no);

    }

    @Test
    public void testSort(){
        Sort sort1 = Sort.by("no").descending();
        Pageable pageable = PageRequest.of(0, 10, sort1);
        Page<Member> result = memberRepository.findAll(pageable);

        result.get().forEach(member -> {
              System.out.println(member);
        });
    }

    @Test
    public void testPageDefault(){
        Pageable page = PageRequest.of(0, 10, Sort.by("no").descending());
        Page<Member> result = memberRepository.findAll(page);
        System.out.println("result: " + result);
        System.out.println("Total pages: " + result.getTotalPages());
        System.out.println("Total Count: " + result.getTotalElements());
        System.out.println("Current Page: " + result.getNumber());
        System.out.println("Current Per Page: " + result.getSize());
        System.out.println("next: " + result.hasNext());
        System.out.println("previous page: " + result.hasPrevious());
        System.out.println("----------------------------------");
        for(Member member : result.getContent()){
            System.out.println(member);
        }
    }

    @Test
    public void testPage(){
        Sort sort1 = Sort.by("no").descending();
        Sort sort2 = Sort.by("no").ascending();

        Sort sortAll = sort1.and(sort2);
        Pageable pageable = PageRequest.of(0, 10, sortAll);
        Page<Member> result = memberRepository.findAll(pageable);
        result.get().forEach(member -> {
            System.out.println(member);
        });
    }
}