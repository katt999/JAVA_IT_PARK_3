package ru.katt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.katt.models.Competition;

import java.util.List;

public interface CompetitionsRepository extends JpaRepository<Competition, Long> {
  List<Competition> findAll();

  /*@Query("SELECT competition.id, " +
          "competition.programSetOuMinisterialPlan, " +
          "competition.programSetOuTargetAdmPlan, " +
          "competition.programSetOuExclusivePlan, " +
          "competition.programSetOuContractPlan, " +
          "formativeOrgunit.shorTitle, " +
          "compensationType.title, " +
          "programForm.title, " +
          "programSubject.title, " +
          "competitionType.title, " +
          "levelType.title " +
          "FROM Competition competition " +
          "INNER JOIN FormativeOrgunit formativeOrgunit ON competition.formativeOrgunitId=formativeOrgunit.id " +
          "INNER JOIN CompensationType compensationType ON competition.compensationTypeId=compensationType.id " +
          "INNER JOIN ProgramForm programForm ON competition.programFormId=programForm.id " +
          "INNER JOIN LevelType levelType ON competition.levelTypeId=levelType.id " +
          "INNER JOIN ProgramSubject programSubject ON competition.programSubjectId=programSubject.id " +
          "INNER JOIN CompetitionType competitionType ON competition.competitionTypeId=competitionType.id " +
          "ORDER BY competition.id") */

  @Query(value = "SELECT competition.id, " +
          "competition.programSetOuMinisterialPlan, " +
          "competition.programSetOuTargetAdmPlan, " +
          "competition.programSetOuExclusivePlan, " +
          "competition.programSetOuContractPlan, " +
          "formativeOrgunit.shorTitle, " +
          "compensationType.title, " +
          "programForm.title, " +
          "programSubject.title, " +
          "competitionType.title, " +
          "levelType.title " +
          "FROM Competition competition " +
          "JOIN competition.FormativeOrgunit formativeOrgunit ON formativeOrgunit.id = :formativeOrgunitId " +
          "JOIN competition.CompensationType compensationType ON compensationType.id = :compensationTypeId " +
          "JOIN competition.ProgramForm programForm ON programForm.id = :programFormId " +
          "JOIN competition.ProgramSubject programSubject ON programSubject.id = :programSubjectId " +
          "JOIN competition.CompetitionType competitionType ON competitionType.id = :competitionTypeId " +
          "JOIN competition.LevelType levelType ON levelType.id = :levelTypeId")
  List<Competition> findByOrderById();
}
