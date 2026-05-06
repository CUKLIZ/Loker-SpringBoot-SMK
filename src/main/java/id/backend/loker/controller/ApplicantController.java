package id.backend.loker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.backend.loker.model.Applicant;
import id.backend.loker.service.ApplicantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/applicants")
@AllArgsConstructor
public class ApplicantController {
    private final ApplicantService service;

    @PostMapping
    public Applicant creApplicant(@RequestBody Applicant applicant) {
        //TODO: process POST request
        return service.create(applicant);        
    }
    
    @GetMapping()
    public List<Applicant> getAll(@RequestParam(required = false) String name) {
        if (name != null) {
            return service.search(name);
        }
        return service.getAll();
    }
    
    @PutMapping("/{id}")
    public Applicant updateApplicant(@PathVariable Long id, @RequestBody Applicant applicant) {
        //TODO: process PUT request
        return service.update(id, applicant);        
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Applicant with ID " + id + " has been successfully deleted.";
    }
}
