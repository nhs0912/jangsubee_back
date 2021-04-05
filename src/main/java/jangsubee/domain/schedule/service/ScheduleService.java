package jangsubee.domain.schedule.service;

import jangsubee.domain.member.entity.Member;
import jangsubee.domain.schedule.entity.Schedule;
import jangsubee.domain.schedule.entity.ScheduleComposition;
import jangsubee.domain.schedule.entity.ScheduleMemberRelation;
import jangsubee.domain.schedule.entity.enums.ScheduleMemberRelationEnum;
import jangsubee.domain.schedule.repository.ScheduleCompositionRepository;
import jangsubee.domain.schedule.repository.ScheduleMemberRelationRepository;
import jangsubee.domain.schedule.repository.ScheduleRepository;
import jangsubee.domain.schedule.service.dto.ScheduleCompositionRegisterIn;
import jangsubee.domain.schedule.service.dto.ScheduleRegisterIn;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final ScheduleCompositionRepository scheduleCompositionRepository;
    private final ScheduleMemberRelationRepository scheduleMemberRelationRepository;

    public Long registerSchedule(Member member, ScheduleRegisterIn registerIn) {
        Schedule schedule = Schedule.builder()
                .member(member)
                .scheduleTypeCode(registerIn.getScheduleTypeCode())
                .scheduleStartDate(registerIn.getScheduleStartDate())
                .scheduleEndDate(registerIn.getScheduleEndDate())
                .scheduleStatusCode(registerIn.getScheduleStatusCode())
                .basicContent(registerIn.getBasicContent())
                .detailContent(registerIn.getDetailContent())
                .build();
        scheduleRepository.save(schedule);
        registerScheduleComposition(schedule, registerIn.getScheduleCompositionRegisterInList());
        registerScheduleMemberRelation(schedule, member);
        return schedule.getId();
    }

    public void registerScheduleComposition(Schedule schedule, List<ScheduleCompositionRegisterIn> scheduleCompositionRegisterInList) {
        for (ScheduleCompositionRegisterIn registerIn : scheduleCompositionRegisterInList) {
            ScheduleComposition scheduleComposition = ScheduleComposition.builder()
                    .schedule(schedule)
                    .scheduleDetailTypeCode(registerIn.getScheduleDetailTypeCode())
                    .date(registerIn.getDate())
                    .startHms(registerIn.getStartHms())
                    .endHms(registerIn.getEndHms())
                    .build();
            scheduleCompositionRepository.save(scheduleComposition);
        }
    }

    private void registerScheduleMemberRelation(Schedule schedule, Member member) {
        ScheduleMemberRelation scheduleMemberRelation = ScheduleMemberRelation.builder()
                .schedule(schedule)
                .member(member)
                .scheduleMemberRelationCode(ScheduleMemberRelationEnum.MANAGER)
                .build();
        scheduleMemberRelationRepository.save(scheduleMemberRelation);
    }

    public Schedule findSchedule(Long scheduleId) {
        Optional<Schedule> schedule = scheduleRepository.findById(scheduleId);
        return schedule.orElseThrow(() -> new NoSuchElementException("존재하지 않는 스케쥴입니다."));
    }
}
