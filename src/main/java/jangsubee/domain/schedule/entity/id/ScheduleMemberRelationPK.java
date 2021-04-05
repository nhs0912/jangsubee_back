package jangsubee.domain.schedule.entity.id;

import jangsubee.domain.schedule.entity.enums.ScheduleMemberRelationEnum;
import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;

@Getter
public class ScheduleMemberRelationPK implements Serializable {

    private Long schedule;
    private String member;
    private ScheduleMemberRelationEnum scheduleMemberRelationCode;
    private int sequenceNumber;

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof ScheduleMemberRelationPK)) {
            return false;
        }
        ScheduleMemberRelationPK targetObj = (ScheduleMemberRelationPK)obj;
        return (this.schedule.equals(targetObj.getSchedule())) &&
                (this.member.equals(targetObj.getMember())) &&
                (this.scheduleMemberRelationCode.equals(targetObj.getScheduleMemberRelationCode())) &&
                (this.sequenceNumber == targetObj.getSequenceNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(schedule, member, scheduleMemberRelationCode, sequenceNumber);
    }
}
