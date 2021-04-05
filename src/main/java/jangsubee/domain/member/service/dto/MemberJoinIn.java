package jangsubee.domain.member.service.dto;

import jangsubee.domain.member.entity.enums.MemberTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemberJoinIn {

    private final String id;
    private final String name;
    private final MemberTypeEnum memberType;
    private final String startDate;
    private final String endDate;
    private final String password;
}
