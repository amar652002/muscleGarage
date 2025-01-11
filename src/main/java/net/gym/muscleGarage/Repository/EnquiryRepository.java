package net.gym.muscleGarage.Repository;

import net.gym.muscleGarage.Entity.EnquiryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnquiryRepository extends JpaRepository<EnquiryEntity,Integer> {
}
