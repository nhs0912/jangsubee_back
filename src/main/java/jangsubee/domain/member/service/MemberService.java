package jangsubee.domain.member.service;

import jangsubee.domain.member.entity.Member;
import jangsubee.domain.member.repository.MemberRepository;
import jangsubee.domain.member.service.dto.MemberJoinIn;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public String join(MemberJoinIn memberJoinIn) {
        Member member = Member.builder()
                .id(memberJoinIn.getId())
                .name(memberJoinIn.getName())
                .memberTypeCode(memberJoinIn.getMemberType())
                .startDate(memberJoinIn.getStartDate())
                .endDate(memberJoinIn.getEndDate())
                .password(memberJoinIn.getPassword())
                .build();
        memberRepository.save(member);
        return member.getId();
    }

    public Member findMember(String id) {
        Optional<Member> member = memberRepository.findById(id);
        return member.orElseThrow(() -> new NoSuchElementException("존재하지 않는 멤버입니다."));
    }
}
