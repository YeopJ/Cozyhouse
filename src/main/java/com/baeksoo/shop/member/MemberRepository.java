package com.baeksoo.shop.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
//repository 함수에서 기본적으로 제공하지 않는 함수를 작성할 수 있음
    Optional<Member> findByUsername(String username);

}
