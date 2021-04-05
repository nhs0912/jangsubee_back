package jangsubee.domain.schedule.repository;

import jangsubee.domain.schedule.entity.ScheduleMemberRelation;
import jangsubee.domain.schedule.entity.id.ScheduleMemberRelationPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleMemberRelationRepository extends JpaRepository<ScheduleMemberRelation, ScheduleMemberRelationPK> {
}
