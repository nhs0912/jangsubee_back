package jangsubee.domain.schedule.entity;

import jangsubee.common.context.CommonContext;
import jangsubee.common.context.dto.LastChangeTransactionInfo;
import jangsubee.domain.member.entity.Member;
import jangsubee.domain.schedule.entity.enums.ScheduleStatusEnum;
import jangsubee.domain.schedule.entity.enums.ScheduleTypeEnum;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "SCHEDULE_M")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="SCHEDULE_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MEMBER_ID")
    private Member member;

    @Convert(converter = ScheduleTypeEnum.ScheduleTypeEnumConverter.class)
    private ScheduleTypeEnum scheduleTypeCode;
    private String scheduleStartDate;
    private String scheduleEndDate;
    @Convert(converter = ScheduleStatusEnum.ScheduleStatusEnumConverter.class)
    private ScheduleStatusEnum scheduleStatusCode;
    private String basicContent;
    private String detailContent;

    @Embedded
    private LastChangeTransactionInfo lastChangeTransactionInfo;

    @Builder
    public Schedule(Member member, ScheduleTypeEnum scheduleTypeCode, String scheduleStartDate, String scheduleEndDate, ScheduleStatusEnum scheduleStatusCode, String basicContent, String detailContent) {
        this.member = member;
        this.scheduleTypeCode = scheduleTypeCode;
        this.scheduleStartDate = scheduleStartDate;
        this.scheduleEndDate = scheduleEndDate;
        this.scheduleStatusCode = scheduleStatusCode;
        this.basicContent = basicContent;
        this.detailContent = detailContent;
        this.lastChangeTransactionInfo = CommonContext.createDefaultLastChangeTransactionInfo();
    }
}
