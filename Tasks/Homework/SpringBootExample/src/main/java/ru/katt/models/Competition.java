package ru.katt.models;

/**
 * Created by EVZabinskaya on 16.12.2017.
 */

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "competition", schema = "public")
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

   /* private FormativeOrgunit formativeOrgUnitId;
    private CompetitionType competitionTypeId;
    private ProgramForm programFormId;
    private ProgramSubject programSubjectId;
    private LevelType levelTypeId;
    private CompensationType compensationTypeId;*/

    @Column (name = "formative_orgunit_id")
    private Long formativeOrgUnitId;

    @Column (name = "competition_type_id")
    private Long competitionTypeId;

    @Column (name = "program_form_id")
    private Long programFormId;

    @Column (name = "program_subject_id")
    private Long programSubjectId;

    @Column (name = "level_type_id")
    private Long levelTypeId;

    @Column (name = "compensation_type_id")
    private Long compensationTypeId;

    @Column (name = "program_set_ministerial_plan")
    private int programSetOuMinisterialPlan;

    @Column (name = "program_set_target_adm_plan")
    private int programSetOuTargetAdmPlan;

    @Column (name = "program_set_exclusive_plan")
    private int programSetOuExclusivePlan;

    @Column (name = "program_set_contract_plan")
    private int programSetOuContractPlan;
}
