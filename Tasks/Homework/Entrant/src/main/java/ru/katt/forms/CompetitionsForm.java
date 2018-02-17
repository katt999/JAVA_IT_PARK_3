package ru.katt.forms;

/**
 * Created by EVZabinskaya on 31.01.2018.
 */
import lombok.Data;
import lombok.ToString;
import ru.katt.models.*;

@Data
@ToString
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
}