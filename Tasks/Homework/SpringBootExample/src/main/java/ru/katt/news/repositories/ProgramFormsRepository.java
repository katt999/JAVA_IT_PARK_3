package ru.katt.news.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.katt.news.models.ProgramForm;

import java.util.List;

public interface ProgramFormsRepository extends JpaRepository<ProgramForm, Long> {
  List<ProgramForm> findAll();
  List<ProgramForm> findByOrderById();
}
