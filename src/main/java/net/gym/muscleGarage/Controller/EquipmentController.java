package net.gym.muscleGarage.Controller;


import net.gym.muscleGarage.Entity.EquipmentEntity;
import net.gym.muscleGarage.Repository.EquipmentRepository;
import net.gym.muscleGarage.Services.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class EquipmentController {

    private final EquipmentService equipmentService;
    private final EquipmentRepository equipmentRepository;

    @Autowired
    public EquipmentController(EquipmentService equipmentService, EquipmentRepository equipmentRepository) {
        this.equipmentService = equipmentService;
        this.equipmentRepository = equipmentRepository;
    }

    @PostMapping("equipment")
    public ResponseEntity<Void> addEquipment(@RequestBody EquipmentEntity equipment){
        equipmentService.saveEquipment(equipment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping( "equipment")
    public List<EquipmentEntity> getEnquirys(){
        return equipmentService.findAllEquipments();
    }

    @GetMapping("equipment/{id}")
    public ResponseEntity<EquipmentEntity> getEquipmentById(@PathVariable Integer id){
        Optional<EquipmentEntity> equipmentFound = equipmentService.findEquipmentById(id);
        return equipmentFound
                .map(equipment -> new ResponseEntity<>(equipment, HttpStatus.OK))
                .orElseGet(() ->new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PutMapping("equipment/{id}")
    public ResponseEntity<EquipmentEntity> updateEquipment(@PathVariable Integer id, @RequestBody EquipmentEntity updatedEquipment){
        EquipmentEntity enquiry = equipmentService.updateEquipmentById(id, updatedEquipment);
        return new ResponseEntity<>(enquiry,HttpStatus.OK);
    }

    @DeleteMapping("equipment/{id}")
    public ResponseEntity<Void> deleteEquipment(@PathVariable Integer id){
        equipmentService.deleteEquipmentById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
