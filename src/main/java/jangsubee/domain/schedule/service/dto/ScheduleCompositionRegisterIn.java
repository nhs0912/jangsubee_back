package jangsubee.domain.schedule.service.dto;

import jangsubee.domain.schedule.entity.enums.ScheduleDetailTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ScheduleCompositionRegisterIn {

    private final ScheduleDetailTypeEnum scheduleDetailTypeCode;
    private final String date;
    private final String startHms;
    private final String endHms;
}
