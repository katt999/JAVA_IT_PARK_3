package ru.katt.forms;

/**
 * Created by EVZabinskaya on 31.01.2018.
 */
import lombok.Data;
import ru.katt.models.*;

@Data
public class CompetitionsForm {
    private Long id;
    private FormativeOrgunit formativeOrgunit;
    private CompetitionType competitionType;
    private ProgramForm programForm;
    private ProgramSubject programSubject;
    private LevelType levelType;
    private CompensationType compensationType;
    private int programSetOuMinisterialPlan;
    private int programSetOuTargetAdmPlan;
    private int programSetOuExclusivePlan;
    private int programSetOuContractPlan;

    public void update(Competition competition) {
        competition.setFormativeOrgunit(this.formativeOrgunit);
        competition.setCompetitionType(this.competitionType);
        competition.setProgramForm(this.programForm);
        competition.setProgramSubject(this.programSubject);
        competition.setLevelType(this.levelType);
        competition.setCompensationType(this.compensationType);
        competition.setProgramSetOuMinisterialPlan(this.programSetOuMinisterialPlan);
        competition.setProgramSetOuTargetAdmPlan(this.programSetOuTargetAdmPlan);
        competition.setProgramSetOuExclusivePlan(this.programSetOuExclusivePlan);
        competition.setProgramSetOuContractPlan(this.programSetOuContractPlan);
    }

}