package net.gym.muscleGarage.Services;

import jakarta.persistence.EntityNotFoundException;
import net.gym.muscleGarage.Entity.MemberEntity;
import net.gym.muscleGarage.Entity.PlanEntity;
import net.gym.muscleGarage.Repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanService {
    private final PlanRepository planRepository;

    @Autowired
    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    //save plan
    public void savePlan(PlanEntity plan) {
        planRepository.save(plan);
    }

    //find plans
    public List<PlanEntity> findAllPlans() {
        return planRepository.findAll();
    }

    //find plan by id
    public Optional<PlanEntity> findPlanById(Integer id) {
        return planRepository.findById(id);
    }

    //update plan by id
    public PlanEntity updatePlanById(Integer id, PlanEntity updatedPlan) {
        return planRepository.findById(id)
                .map(existingPlan -> {

                    existingPlan.setPlanName(updatedPlan.getPlanName());
                    existingPlan.setAmount(updatedPlan.getAmount());
                    existingPlan.setDuration(updatedPlan.getDuration());

                    return planRepository.save(existingPlan);
                })
                .orElseThrow(() -> new EntityNotFoundException("Plan not found with id: " + id));
    }

    //delete plan by id
    public void deletePlanById(Integer id) {
        planRepository.deleteById(id);
    }

}
