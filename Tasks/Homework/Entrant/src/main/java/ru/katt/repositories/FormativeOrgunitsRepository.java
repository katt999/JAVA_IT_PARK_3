package ru.katt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.katt.models.FormativeOrgunit;

import java.util.List;

public interface FormativeOrgunitsRepository extends JpaRepository<FormativeOrgunit, Long> {
  List<FormativeOrgunit> findAll();
  List<FormativeOrgunit> findByOrderById();
  List<FormativeOrgunit> findByOrderByShortTitle();
  List<FormativeOrgunit> findByOrderByFullTitle();
}
