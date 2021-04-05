package jangsubee.domain.schedule.entity;

import jangsubee.common.context.CommonContext;
import jangsubee.common.context.dto.LastChangeTransactionInfo;
import jangsubee.domain.member.entity.Member;
import jangsubee.domain.schedule.entity.enums.ScheduleMemberRelationEnum;
import jangsubee.domain.schedule.entity.id.ScheduleMemberRelationPK;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "SCHEDULE_MEMBER_R")
@IdClass(ScheduleMemberRelationPK.class)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ScheduleMemberRelation {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SCHEDULE_ID")
    private Schedule schedule;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @Id
    @Convert(converter = ScheduleMemberRelationEnum.ScheduleMemberRelationEnumConverter.class)
    private ScheduleMemberRelationEnum scheduleMemberRelationCode;
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int sequenceNumber;

    @Embedded
    private LastChangeTransactionInfo lastChangeTransactionInfo;

    @Builder
    public ScheduleMemberRelation(Schedule schedule, Member member, ScheduleMemberRelationEnum scheduleMemberRelationCode, int sequenceNumber) {
        this.schedule = schedule;
        this.member = member;
        this.scheduleMemberRelationCode = scheduleMemberRelationCode;
        this.sequenceNumber = sequenceNumber;
        this.lastChangeTransactionInfo = CommonContext.createDefaultLastChangeTransactionInfo();
    }
}
