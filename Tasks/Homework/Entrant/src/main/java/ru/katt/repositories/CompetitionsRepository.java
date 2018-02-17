package ru.katt.repositories;

/**
 * Created by EVZabinskaya on 31.01.2018.
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.katt.models.Competition;

import java.util.HashMap;
import java.util.List;

public interface CompetitionsRepository extends JpaRepository<Competition, Long> {

    List<Competition> findAll();
    List<Competition> findByOrderById();
    Competition findOne(Long competitionId);

    @Query(nativeQuery = true, value = "SELECT   " +
            "  (SELECT w.position FROM " +
            "    (SELECT ed1.id, " +
            "                  sum(ee1.mark) AS marks," +
            "                  ROW_NUMBER() OVER(ORDER BY sum(ee1.mark) DESC) AS position " +
            "     FROM entrant_data ed1 INNER JOIN " +
            "       entrant_competition ec1 ON ed1.id = ec1.entrant_id INNER JOIN " +
            "       exam_entrant ee1 ON ed1.id=ee1.entrant_id " +
            "     WHERE ec1.competition_id = ec.competition_id " +
            "     GROUP BY ed1.id) as w " +
            "  WHERE w.id = ?1) AS position " +
            "FROM entrant_data ed INNER JOIN " +
            "  entrant_competition ec ON ed.id = ec.entrant_id  " +
            "WHERE ed.id = ?1")
    List<Integer> findPosition(Long entrantId);

}
