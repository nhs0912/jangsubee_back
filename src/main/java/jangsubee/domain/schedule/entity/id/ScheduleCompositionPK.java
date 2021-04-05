package jangsubee.domain.schedule.entity.id;

import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;

@Getter
public class ScheduleCompositionPK implements Serializable {

    private Long schedule;
    private int sequenceNumber;

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof ScheduleCompositionPK)) {
            return false;
        }
        ScheduleCompositionPK targetObj = (ScheduleCompositionPK)obj;
        return (this.schedule.equals(targetObj.getSchedule())) &&
                (this.sequenceNumber == targetObj.getSequenceNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(schedule, sequenceNumber);
    }
}
