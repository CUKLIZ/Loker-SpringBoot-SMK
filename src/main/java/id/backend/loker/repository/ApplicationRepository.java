package id.backend.loker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import id.backend.loker.model.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByJobId(Long jobId);
}
