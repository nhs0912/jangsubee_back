package jangsubee.domain.member.entity;

import jangsubee.common.context.CommonContext;
import jangsubee.common.context.dto.LastChangeTransactionInfo;
import jangsubee.domain.member.entity.enums.MemberTypeEnum;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "MEMBER_M")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @Column(name="MEMBER_ID")
    private String id; // 사번을 그대로 사용

    private String name;
    @Convert(converter = MemberTypeEnum.MemberTypeEnumConverter.class)
    private MemberTypeEnum memberTypeCode;
    private String startDate;
    private String endDate;
    private String password;

    @Embedded
    private LastChangeTransactionInfo lastChangeTransactionInfo;

    @Builder
    public Member(String id, String name, MemberTypeEnum memberTypeCode, String startDate, String endDate, String password) {
        this.id = id;
        this.name = name;
        this.memberTypeCode = memberTypeCode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.password = password;
        this.lastChangeTransactionInfo = CommonContext.createDefaultLastChangeTransactionInfo();
    }
}
