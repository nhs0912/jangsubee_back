package jangsubee.domain.schedule.repository;

import jangsubee.domain.schedule.entity.ScheduleComposition;
import jangsubee.domain.schedule.entity.id.ScheduleCompositionPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleCompositionRepository extends JpaRepository<ScheduleComposition, ScheduleCompositionPK> {
}
