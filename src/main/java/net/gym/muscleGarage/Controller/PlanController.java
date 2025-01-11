package net.gym.muscleGarage.Controller;

import net.gym.muscleGarage.Entity.MemberEntity;
import net.gym.muscleGarage.Entity.PlanEntity;
import net.gym.muscleGarage.Repository.PlanRepository;
import net.gym.muscleGarage.Services.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class PlanController {

    private final PlanService planService;
    private final PlanRepository planRepository;

    @Autowired
    public PlanController(PlanService planService, PlanRepository planRepository) {
        this.planService = planService;
        this.planRepository = planRepository;
    }

    @PostMapping("plan")
    public ResponseEntity<Void> addPlan(@RequestBody PlanEntity plan){
        planService.savePlan(plan);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping( "plan")
    public List<PlanEntity> getPlans(){
        return planService.findAllPlans();
    }

    @GetMapping("plan/{id}")
    public ResponseEntity<PlanEntity> getPlanById(@PathVariable Integer id){
        Optional<PlanEntity> planFound = planService.findPlanById(id);
        return planFound
                .map(plan -> new ResponseEntity<>(plan, HttpStatus.OK))
                .orElseGet(() ->new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PutMapping("plan/{id}")
    public ResponseEntity<PlanEntity> planEnquiry(@PathVariable Integer id, @RequestBody PlanEntity updatedPlan){
        PlanEntity plan = planService.updatePlanById(id, updatedPlan);
        return new ResponseEntity<>(plan,HttpStatus.OK);
    }

    @DeleteMapping("plan/{id}")
    public ResponseEntity<Void> deletePlan(@PathVariable Integer id){
        planService.deletePlanById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
