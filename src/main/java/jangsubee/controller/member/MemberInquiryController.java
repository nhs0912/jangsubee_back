package jangsubee.controller.member;

import jangsubee.controller.member.dto.MemberInquiryRes;
import jangsubee.domain.member.entity.Member;
import jangsubee.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberInquiryController {

    private final MemberService memberService;

    @GetMapping("/member/{memberId}")
    public MemberInquiryRes inquiryMember(@PathVariable String memberId) {
        Member member = memberService.findMember(memberId);
        return new MemberInquiryRes(member.getId(), member.getName(), member.getMemberTypeCode().getDescription());
    }
}
