package jangsubee.controller.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemberInquiryRes {

    private final String id;
    private final String name;
    private final String memberType;
}
