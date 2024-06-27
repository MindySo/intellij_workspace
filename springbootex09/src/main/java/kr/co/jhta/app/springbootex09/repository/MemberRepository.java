package kr.co.jhta.app.springbootex09.repository;

import kr.co.jhta.app.springbootex09.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    // 테스트 케이스 작성하여 총 데이터가 몇개 있는지 검사
    Page<Member> findByName(String name, Pageable pageable);

    List<Member> findByNoLessThan(int no);          //미만
    List<Member> findByNoLessThanEqual(int no);     //이하
    List<Member> findByNoGreaterThan(int no);       //초과
    List<Member> findByNoGreaterThanEqual(int no);  //이상
    List<Member> findByNoBetweenOrderByNameDesc(int no1, int no2);  //사이

    List<Member> findByNameContaining(String keyword);

    void deleteByNoGreaterThanEqual(int no);
//    List<Member> findByNoLessThanEqualAsc(int no);

    // JPQL 쿼리를 통한 사용자 정의 쿼리
    @Query("SELECT m FROM Member m WHERE m.name LIKE %:name%")
    List<Member> findMember(@Param("name")String name);

    @Query(value = "SELECT m FROM Member m WHERE m.id = %:id% AND m.pw = %:pw%")
    Member findMemberByIdAndPw(@Param("id")String id, @Param("id")String pw);


}
