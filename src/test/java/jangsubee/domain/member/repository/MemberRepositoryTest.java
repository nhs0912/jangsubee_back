package jangsubee.domain.member.repository;

import jangsubee.domain.member.entity.Member;
import jangsubee.domain.member.entity.enums.MemberTypeEnum;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void saveMember() {

        Member member = Member.builder()
                .id("STAFF1")
                .name("홍길동")
                .memberTypeCode(MemberTypeEnum.TEAM_MEMBER)
                .startDate("20210227")
                .endDate("99991231")
                .password("123456")
                .build();

        Member savedMember = memberRepository.save(member);

        memberRepository.findById(savedMember.getId()).ifPresent(findMember -> Assertions.assertThat(findMember.getId()).isEqualTo(member.getId()));
    }
}