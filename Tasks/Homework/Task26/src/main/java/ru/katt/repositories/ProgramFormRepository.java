package ru.katt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.katt.models.ProgramForm;

import java.util.List;

/**
 * Created by EVZabinskaya on 20.01.2018.
 */
public interface  ProgramFormRepository extends JpaRepository<ProgramForm, Long> {
    List<ProgramForm> findAll();

}
