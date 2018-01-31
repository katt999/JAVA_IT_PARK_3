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

    @OneToOne
    @JoinColumn (name = "formative_orgunit_id")
    private FormativeOrgunit formativeOrgunit;

    @OneToOne
    @JoinColumn (name = "competition_type_id")
    private CompetitionType competitionType;

    @OneToOne
    @JoinColumn(name = "compensation_type_id")
    private CompensationType compensationType;

    @OneToOne
    @JoinColumn (name = "program_form_id")
    private ProgramForm programForm;

    @OneToOne
    @JoinColumn (name = "program_subject_id")
    private ProgramSubject programSubject;

    @OneToOne
    @JoinColumn(name = "level_type_id")
    private LevelType levelType;

    @Column (name = "program_set_ministerial_plan")
    private int programSetOuMinisterialPlan;

    @Column (name = "program_set_target_adm_plan")
    private int programSetOuTargetAdmPlan;

    @Column (name = "program_set_exclusive_plan")
    private int programSetOuExclusivePlan;

    @Column (name = "program_set_contract_plan")
    private int programSetOuContractPlan;
}