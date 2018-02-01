package ru.katt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.katt.models.LevelType;

import java.util.List;

public interface LevelTypesRepository extends JpaRepository<LevelType, Long> {
  List<LevelType> findAll();
  List<LevelType> findByOrderById();
}
