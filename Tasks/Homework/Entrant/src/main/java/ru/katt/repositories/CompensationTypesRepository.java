package ru.katt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.katt.models.CompensationType;

import java.util.List;

public interface CompensationTypesRepository extends JpaRepository<CompensationType, Long> {
  List<CompensationType> findAll();
  List<CompensationType> findByOrderById();
}
