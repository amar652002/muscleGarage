package net.gym.muscleGarage.Repository;

import net.gym.muscleGarage.Entity.PlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<PlanEntity,Integer> {
}
