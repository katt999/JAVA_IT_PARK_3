package ru.katt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.katt.models.Entrant;

import java.util.List;

/**
 * Created by user on 06.02.2018.
 */
public interface EntrantsRepository extends JpaRepository<Entrant, Long> {

        List<Entrant> findAll();
        List<Entrant> findByOrderById();
        Entrant findOne(Long entrantId);

        @Query(nativeQuery = true, value = "SELECT * FROM entrant_data where id = ?1 AND email = ?2")
        Entrant findByIdAndEmail(Long entrantId,String email);

        @Query(nativeQuery = true, value = "SELECT ed.*, SUM(ee.mark) as marks, " +
             "(ROW_NUMBER() OVER (PARTITION BY c.competition_type_id " +
             "ORDER BY SUM(ee.mark) DESC)) AS position, " +
             "c.competition_type_id " +
             "FROM entrant_data ed INNER JOIN " +
             "entrant_competition ec ON ed.id = ec.entrant_id INNER JOIN " +
             "competition c ON c.id = ec.competition_id INNER JOIN " +
             "exam_entrant ee ON ed.id=ee.entrant_id " +
             "where c.formative_orgunit_id=?1 AND " +
             "c.program_form_id=?2 AND " +
             "c.compensation_type_id=?3 AND " +
             "c.level_type_id=?4 AND " +
             "c.program_subject_id=?5 " +
             "GROUP BY ed.id,c.competition_type_id " +
             "ORDER BY c.competition_type_id, position, marks")
        List<Entrant> findListEntrant(long parameter1,long parameter2,long parameter3,long parameter4,long parameter5);

 }
