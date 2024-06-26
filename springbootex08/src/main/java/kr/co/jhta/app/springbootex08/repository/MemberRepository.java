package kr.co.jhta.app.springbootex08.repository;

import kr.co.jhta.app.springbootex08.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
// MemberRepositoryimple
// 추상메서드
public interface MemberRepository extends JpaRepository<Member, Long> {
    // insert : save(엔터티 객체)
    // select : findById(키타입), getOne(키타입)
    // update : save(엔터티 객체)
    // delete : deleteById(키타입) , delete(엔티티객체)
}
