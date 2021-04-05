package jangsubee.domain.schedule.service.dto;

import jangsubee.domain.schedule.entity.enums.ScheduleStatusEnum;
import jangsubee.domain.schedule.entity.enums.ScheduleTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ScheduleRegisterIn {

    private final ScheduleTypeEnum scheduleTypeCode;
    private final String scheduleStartDate;
    private final String scheduleEndDate;
    private final ScheduleStatusEnum scheduleStatusCode;
    private final String basicContent;
    private final String detailContent;

    private final List<ScheduleCompositionRegisterIn> scheduleCompositionRegisterInList;
}
