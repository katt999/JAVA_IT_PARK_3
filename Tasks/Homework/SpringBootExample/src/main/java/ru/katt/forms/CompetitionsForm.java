package ru.katt.forms;

import lombok.Data;
import ru.katt.models.*;

@Data
public class CompetitionsForm {
  private Long id;
  private Long formativeOrgUnitId;
  private Long competitionTypeId;
  private Long programFormId;
  private Long programSubjectId;
  private Long levelTypeId;
  private Long compensationTypeId;
  private int programSetOuMinisterialPlan;
  private int programSetOuTargetAdmPlan;
  private int programSetOuExclusivePlan;
  private int programSetOuContractPlan;

  public void update(Competition competition) {
    competition.setFormativeOrgUnitId(this.formativeOrgUnitId);
    competition.setCompetitionTypeId(this.competitionTypeId);
    competition.setProgramFormId(this.programFormId);
    competition.setProgramSubjectId(this.programSubjectId);
    competition.setLevelTypeId(this.levelTypeId);
    competition.setCompensationTypeId(this.compensationTypeId);
    competition.setProgramSetOuMinisterialPlan(this.programSetOuMinisterialPlan);
    competition.setProgramSetOuTargetAdmPlan(this.programSetOuTargetAdmPlan);
    competition.setProgramSetOuExclusivePlan(this.programSetOuExclusivePlan);
    competition.setProgramSetOuContractPlan(this.programSetOuContractPlan);
  }

}
