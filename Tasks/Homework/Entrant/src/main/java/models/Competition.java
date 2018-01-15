package models;

/**
 * Created by EVZabinskaya on 16.12.2017.
 */

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private FormativeOrgunit formativeOrgUnitId;
    private CompetitionType competitionTypeId;
    private ProgramForm programFormId;
    private ProgramSubject programSubjectId;
    private LevelType levelTypeId;
    private CompensationType compensationTypeId;
    private int programSetOuMinisterialPlan;
    private int programSetOuTargetAdmPlan;
    private int programSetOuExclusivePlan;
    private int programSetOuContractPlan;
}
