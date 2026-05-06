package id.backend.loker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.backend.loker.model.Application;
import id.backend.loker.model.DTO.ApplicationChangeDTO;
import id.backend.loker.model.DTO.ApplicationRegisterDTO;
import id.backend.loker.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/application")
@RequiredArgsConstructor
public class ApplicationController {
    private final ApplicationService service;

    @PostMapping("/register")
    public Application creaApplication(@RequestBody ApplicationRegisterDTO applicationRegisterDTO) {
        //TODO: process POST request
        return service.register(applicationRegisterDTO.getJobId(), applicationRegisterDTO.getApplicantId());
    }
    
    @PostMapping("/change")
    public Application changeApplication(@RequestBody ApplicationChangeDTO applicationChangeDTO) {
        //TODO: process POST request
        return service.change(applicationChangeDTO.getId(), applicationChangeDTO.getStatus());
    }

    @GetMapping()
    public List<Application> gettApplication(@RequestParam(name = "job") Long jobId) {
        return service.getByJob(jobId);
    }
}
