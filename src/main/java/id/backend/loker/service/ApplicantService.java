package id.backend.loker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import id.backend.loker.model.Applicant;
import id.backend.loker.repository.ApplicantRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApplicantService {

    private final ApplicantRepository repository;

    public Applicant create(Applicant a) {
        return repository.save(a);
    }

    public List<Applicant> getAll() {
        return repository.findAll();
    }

    public List<Applicant> search(String name) {
        return repository.findByNameContaining(name);
    }

    public Applicant update(Long id, Applicant a) {
        a.setId(id);
        return repository.save(a);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}