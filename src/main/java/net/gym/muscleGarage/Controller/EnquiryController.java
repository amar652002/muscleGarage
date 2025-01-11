package net.gym.muscleGarage.Controller;

import net.gym.muscleGarage.Entity.EnquiryEntity;
import net.gym.muscleGarage.Repository.EnquiryRepository;
import net.gym.muscleGarage.Services.EnquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/")
public class EnquiryController {

    private final EnquiryService enquiryService;
    private final EnquiryRepository enquiryRepository;

    @Autowired
    public EnquiryController(EnquiryService enquiryService, EnquiryRepository enquiryRepository) {
        this.enquiryService = enquiryService;
        this.enquiryRepository = enquiryRepository;
    }

    @PostMapping("enquiry")
    public ResponseEntity<Void> addEnquiry(@RequestBody EnquiryEntity enquiry){
        enquiryService.saveEnquiry(enquiry);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping( "enquiry")
    public List<EnquiryEntity> getEnquirys(){
        return enquiryService.findAllEnquirys();
    }

    @GetMapping("enquiry/{id}")
    public ResponseEntity<EnquiryEntity> getEnquiryById(@PathVariable Integer id){
        Optional<EnquiryEntity> enquiryFound = enquiryService.findEnquiryById(id);
        return enquiryFound
                .map(enquiry -> new ResponseEntity<>(enquiry, HttpStatus.OK))
                .orElseGet(() ->new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PutMapping("enquiry/{id}")
    public ResponseEntity<EnquiryEntity> updateEnquiry(@PathVariable Integer id, @RequestBody EnquiryEntity updatedEnquiry){
        EnquiryEntity enquiry = enquiryService.updateEnquiryById(id, updatedEnquiry);
        return new ResponseEntity<>(enquiry,HttpStatus.OK);
    }

    @DeleteMapping("enquiry/{id}")
    public ResponseEntity<Void> deleteEnquiry(@PathVariable Integer id){
        enquiryService.deleteEnquiryById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
