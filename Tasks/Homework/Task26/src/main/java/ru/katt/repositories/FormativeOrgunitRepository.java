package ru.katt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.katt.models.FormativeOrgunit;

import java.util.List;

/**
 * Created by EVZabinskaya on 20.01.2018.
 */
public interface FormativeOrgunitRepository extends JpaRepository<FormativeOrgunit, Long> {
    List<FormativeOrgunit> findAll();

    List<FormativeOrgunit> findByShortTitle(String shortTitle);

}
