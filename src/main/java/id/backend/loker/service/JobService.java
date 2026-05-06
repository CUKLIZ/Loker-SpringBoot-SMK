package id.backend.loker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import id.backend.loker.model.Job;
import id.backend.loker.repository.JobRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobService {
    private final JobRepository repository;

    public Job createJob(Job job) {
        return repository.save(job);
    }

    public List<Job> getAll() {
        return repository.findAll();
    }

     public List<Job> search(String name) {
        return repository.findByTitleContaining(name);
    }

    public Job update(Long id, Job job) {
        job.setId(id);
        return repository.save(job);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
