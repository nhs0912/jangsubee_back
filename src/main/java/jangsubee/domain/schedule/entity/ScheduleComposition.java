package jangsubee.domain.schedule.entity;

import jangsubee.common.context.CommonContext;
import jangsubee.common.context.dto.LastChangeTransactionInfo;
import jangsubee.domain.schedule.entity.enums.ScheduleDetailTypeEnum;
import jangsubee.domain.schedule.entity.id.ScheduleCompositionPK;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "SCHEDULE_COMPOSITION_D")
@IdClass(ScheduleCompositionPK.class)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ScheduleComposition {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SCHEDULE_ID")
    private Schedule schedule;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int sequenceNumber;

    @Convert(converter = ScheduleDetailTypeEnum.ScheduleDetailTypeEnumConverter.class)
    private ScheduleDetailTypeEnum scheduleDetailTypeCode;
    private String date;
    private String startHms;
    private String endHms;

    @Embedded
    private LastChangeTransactionInfo lastChangeTransactionInfo;

    @Builder
    public ScheduleComposition(Schedule schedule, int sequenceNumber, ScheduleDetailTypeEnum scheduleDetailTypeCode, String date, String startHms, String endHms) {
        this.schedule = schedule;
        this.sequenceNumber = sequenceNumber;
        this.scheduleDetailTypeCode = scheduleDetailTypeCode;
        this.date = date;
        this.startHms = startHms;
        this.endHms = endHms;
        this.lastChangeTransactionInfo = CommonContext.createDefaultLastChangeTransactionInfo();
    }
}
