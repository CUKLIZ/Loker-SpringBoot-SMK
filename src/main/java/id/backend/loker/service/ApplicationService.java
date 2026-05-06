package id.backend.loker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import id.backend.loker.model.Application;
import id.backend.loker.repository.ApplicantRepository;
import id.backend.loker.repository.ApplicationRepository;
import id.backend.loker.repository.JobRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationRepository repo;
    private final JobRepository jobRepo;
    private final ApplicantRepository applicantRepo;

    public Application register(Long jobId, Long applicantId) {
        Application app = new Application();
        app.setJob(jobRepo.findById(jobId).orElseThrow());
        app.setApplicant(applicantRepo.findById(applicantId).orElseThrow());
        app.setStatus(Application.Status.SUBMITTED);
        return repo.save(app);
    }

    // public Application change(Long id, String status) {
    //     Application app = repo.findById(id).orElseThrow();
    //     // app.setStatus(Application.Status.valueOf(status));
    //     app.setStatus(Application.Status.valueOf(status.toUpperCase()));
    //     return repo.save(app);
    // }

    public Application change(Long id, String status) {
        Application app = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Applicaton ID " + id + " not found"));
        
        try {
            app.setStatus(Application.Status.valueOf(status.trim().toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Status '" + status + "' is invalid. Use: SUBMITTED, REVIEWED, ACCEPTED, or REJECTED");
        }
        return repo.save(app);
    }

    public List<Application> getByJob(Long jobId) {
        return repo.findByJobId(jobId);
    }
}
