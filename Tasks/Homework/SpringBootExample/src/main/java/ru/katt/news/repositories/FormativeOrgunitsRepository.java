package ru.katt.news.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.katt.news.models.FormativeOrgunit;

import java.util.List;
import java.util.Optional;

public interface FormativeOrgunitsRepository extends JpaRepository<FormativeOrgunit, Long> {
  List<FormativeOrgunit> findAll();
  List<FormativeOrgunit> findByOrderById();
  List<FormativeOrgunit> findByOrderByShortTitle();
  List<FormativeOrgunit> findByOrderByFullTitle();
}
