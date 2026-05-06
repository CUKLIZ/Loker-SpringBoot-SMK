package id.backend.loker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import id.backend.loker.model.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
    List<Applicant> findByNameContaining(String name);
}
