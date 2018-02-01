package ru.katt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.katt.models.CompetitionType;

import java.util.List;

public interface CompetitionTypesRepository extends JpaRepository<CompetitionType, Long> {
  List<CompetitionType> findAll();
  List<CompetitionType> findByOrderById();
}
