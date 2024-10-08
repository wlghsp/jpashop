package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    @Rollback(value = false)
    void 회원가입() {
        // Given
        Member member = new Member("kim");

        // When
        Long saveId = memberService.join(member);

        // Then
        assertEquals(member, memberRepository.findById(saveId).get());
    }

    @Test
    void 중복_회원_예외() {
        // Given
        Member member1 = new Member("kim");

        Member member2 = new Member("kim");

        // When
        memberService.join(member1);

        // Then
        Assertions.assertThrows(IllegalStateException.class, () -> {
            memberService.join(member2); // 예외가 발생해야 한다.
        });
    }
}