package net.gym.muscleGarage.Services;

import jakarta.persistence.EntityNotFoundException;
import net.gym.muscleGarage.Entity.EnquiryEntity;
import net.gym.muscleGarage.Repository.EnquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnquiryService {
    
    private final EnquiryRepository enquiryRepository;

    @Autowired
    public EnquiryService(EnquiryRepository enquiryRepository) {
        this.enquiryRepository = enquiryRepository;
    }

    //save enquiry
    public void saveEnquiry(EnquiryEntity enquiry) {
        enquiryRepository.save(enquiry);
    }

    //find enquirys
    public List<EnquiryEntity> findAllEnquirys() {
        return enquiryRepository.findAll();
    }

    //find enquiry by id
    public Optional<EnquiryEntity> findEnquiryById(Integer id) {
        return enquiryRepository.findById(id);
    }

    //update enquiry by id
    public EnquiryEntity updateEnquiryById(Integer id, EnquiryEntity updatedEnquiry) {
        return enquiryRepository.findById(id)
                .map(existingEnquiry -> {
                    
                    existingEnquiry.setName(updatedEnquiry.getName());
                    existingEnquiry.setPhno(updatedEnquiry.getPhno());
                    existingEnquiry.setEmail(updatedEnquiry.getEmail());
                    existingEnquiry.setAge(updatedEnquiry.getAge());
                    existingEnquiry.setGender(updatedEnquiry.getGender());

                    return enquiryRepository.save(existingEnquiry);
                })
                .orElseThrow(() -> new EntityNotFoundException("Enquiry not found with id: " + id));
    }
    //delete enquiry
    public void deleteEnquiryById(Integer id) {
        enquiryRepository.deleteById(id);
    }

}
