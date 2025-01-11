package net.gym.muscleGarage.Repository;

import net.gym.muscleGarage.Entity.EquipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends JpaRepository<EquipmentEntity,Integer> {
}
