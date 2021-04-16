package jangsubee.domain.schedule.service;

import jangsubee.domain.member.entity.Member;
import jangsubee.domain.member.entity.enums.MemberTypeEnum;
import jangsubee.domain.member.service.MemberService;
import jangsubee.domain.member.service.dto.MemberJoinIn;
import jangsubee.domain.schedule.entity.Schedule;
import jangsubee.domain.schedule.entity.enums.ScheduleDetailTypeEnum;
import jangsubee.domain.schedule.entity.enums.ScheduleStatusEnum;
import jangsubee.domain.schedule.entity.enums.ScheduleTypeEnum;
import jangsubee.domain.schedule.service.dto.ScheduleCompositionRegisterIn;
import jangsubee.domain.schedule.service.dto.ScheduleRegisterIn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ScheduleServiceTest {

    @Autowired
    private MemberService memberService;
    @Autowired
    private ScheduleService scheduleService;

    @Test
    @DisplayName("스케쥴 등록 기본테스트")
    public void register() {
        // given
        MemberJoinIn memberJoinIn = new MemberJoinIn(
                "STAFF1",
                "홍길동",
                MemberTypeEnum.TEAM_MEMBER,
                "20210314",
                "99991231",
                "123456"
        );

        List<ScheduleCompositionRegisterIn> compositionRegisterInList = new ArrayList<>();
        compositionRegisterInList.add(new ScheduleCompositionRegisterIn(
                ScheduleDetailTypeEnum.VACATION,
                "20210314",
                "090000",
                "180000"
        ));

        compositionRegisterInList.add(new ScheduleCompositionRegisterIn(
                ScheduleDetailTypeEnum.VACATION,
                "20210315",
                "090000",
                "180000"
        ));

        ScheduleRegisterIn scheduleRegisterIn = new ScheduleRegisterIn(
                ScheduleTypeEnum.VACATION,
                "20210315",
                "20210315",
                ScheduleStatusEnum.ACTIVE,
                "연차휴가 사용",
                "",
                compositionRegisterInList
        );

        // when
        String join = memberService.join(memberJoinIn);
        Member member = memberService.findMember(join);

        Long scheduleId = scheduleService.registerSchedule(member, scheduleRegisterIn);
        Schedule schedule = scheduleService.findSchedule(scheduleId);

        // then
        assertThat("STAFF1").isEqualTo(schedule.getMember().getId());
        assertThat("연차휴가 사용").isEqualTo(schedule.getBasicContent());
    }
}