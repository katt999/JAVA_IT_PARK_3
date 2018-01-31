package ru.katt.repositories;

/**
 * Created by EVZabinskaya on 31.01.2018.
 */
import org.springframework.data.jpa.repository.JpaRepository;
import ru.katt.models.Competition;

import java.util.List;

public interface CompetitionsRepository extends JpaRepository<Competition, Long> {
    List<Competition> findAll();

    List<Competition> findByOrderById();
}
