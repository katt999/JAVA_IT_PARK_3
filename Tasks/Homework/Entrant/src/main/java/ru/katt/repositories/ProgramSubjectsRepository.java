package ru.katt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.katt.models.ProgramSubject;

import java.util.List;

public interface ProgramSubjectsRepository extends JpaRepository<ProgramSubject, Long> {
  List<ProgramSubject> findAll();
  List<ProgramSubject> findByOrderById();
}
