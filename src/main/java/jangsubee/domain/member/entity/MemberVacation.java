package jangsubee.domain.member.entity;

import jangsubee.common.context.dto.LastChangeTransactionInfo;
import jangsubee.domain.member.entity.id.MemberVacationPK;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "MEMBER_VACATION_D")
@IdClass(MemberVacationPK.class)
@Getter @Setter
public class MemberVacation {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @Id
    private String year;

    private int totalVacationDayCount;
    private int usedVacationDayCount;
    private int specialVacationDayCount;

    @Embedded
    private LastChangeTransactionInfo lastChangeTransactionInfo;
}
