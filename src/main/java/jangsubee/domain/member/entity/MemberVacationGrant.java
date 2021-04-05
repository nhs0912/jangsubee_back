package jangsubee.domain.member.entity;

import jangsubee.common.context.dto.LastChangeTransactionInfo;
import jangsubee.domain.member.entity.enums.VacationGrantReasonEnum;
import jangsubee.domain.member.entity.id.MemberVacationGrantPK;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "MEMBER_VACATION_GRANT_D")
@IdClass(MemberVacationGrantPK.class)
@Getter @Setter
public class MemberVacationGrant {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @Id
    private String grantDate;
    @Id
    private int sequenceNumber;

    @Convert(converter = VacationGrantReasonEnum.VacationGrantReasonEnumConverter.class)
    private VacationGrantReasonEnum vacationGrantReasonCode;
    private int grantDayCount;

    @Embedded
    private LastChangeTransactionInfo lastChangeTransactionInfo;
}
