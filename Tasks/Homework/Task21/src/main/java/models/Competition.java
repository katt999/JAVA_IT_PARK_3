package models;

/**
 * Created by EVZabinskaya on 16.12.2017.
 */
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Competition {
    private int id;
    private int formativeOrgUnitId;
    private int competitionTypeId;
    private int programFormId;
    private int programSubjectId;
    private int levelTypeId;
    private int programSetOuMinisterialPlan;
    private int programSetOuTargetAdmPlan;
    private int programSetOuExclusivePlan;
    private int programSetOuContractPlan;
    private int compensationTypeId;
}
