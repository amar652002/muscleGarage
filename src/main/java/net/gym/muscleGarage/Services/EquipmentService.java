package net.gym.muscleGarage.Services;

import jakarta.persistence.EntityNotFoundException;
import net.gym.muscleGarage.Entity.EnquiryEntity;
import net.gym.muscleGarage.Entity.EquipmentEntity;
import net.gym.muscleGarage.Repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {
    
    private final EquipmentRepository equipmentRepository;
    
    @Autowired
    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    //save equipment
    public void saveEquipment(EquipmentEntity equipment) {
        equipmentRepository.save(equipment);
    }

    //find equipments
    public List<EquipmentEntity> findAllEquipments() {
        return equipmentRepository.findAll();
    }

    //find equipment by id
    public Optional<EquipmentEntity> findEquipmentById(Integer id) {
        return equipmentRepository.findById(id);
    }

    //update equipment by id
    public EquipmentEntity updateEquipmentById(Integer id, EquipmentEntity updatedEquipment) {
        return equipmentRepository.findById(id)
                .map(existingEquipment -> {
                    existingEquipment.setEquipmentName(updatedEquipment.getEquipmentName());
                    existingEquipment.setPrice(updatedEquipment.getPrice());
                    existingEquipment.setUnit(updatedEquipment.getUnit());
                    existingEquipment.setPurchaseDate(updatedEquipment.getPurchaseDate());
                    existingEquipment.setDescription(updatedEquipment.getDescription());
    
                    return equipmentRepository.save(existingEquipment);
                })
                .orElseThrow(() -> new EntityNotFoundException("Equipment not found with id: " + id));
    }

    //delete equipment by id
    public void deleteEquipmentById(Integer id) {
        equipmentRepository.deleteById(id);
    }
    
}
