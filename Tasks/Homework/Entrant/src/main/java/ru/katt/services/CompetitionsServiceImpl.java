package ru.katt.services;

/**
 * Created by EVZabinskaya on 31.01.2018.
 */

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.katt.forms.CompetitionsForm;
import ru.katt.models.*;
import ru.katt.repositories.*;

import java.util.List;

@Service
public class CompetitionsServiceImpl implements CompetitionsService {

    @Autowired
    private CompetitionsRepository competitionsRepository;

    @Autowired
    private FormativeOrgunitsRepository formativeOrgunitsRepository;

    @Autowired
    private ProgramFormsRepository programFormsRepository;

    @Autowired
    private LevelTypesRepository levelTypesRepository;

    @Autowired
    private CompetitionTypesRepository competitionTypesRepository;

    @Autowired
    private CompensationTypesRepository compensationTypesRepository;

    @Autowired
    private ProgramSubjectsRepository programSubjectsRepository;

    @Override
    public List<Competition> getCompetitions(String orderBy) {
        switch (orderBy) {
            case "id": return competitionsRepository.findByOrderById();
            default: return competitionsRepository.findAll();
        }
    }

    @Override
    public List<FormativeOrgunit> getFormativeOrgunits() {
        return formativeOrgunitsRepository.findAll();
    }

    @Override
    public List<ProgramForm> getProgramForms() {
        return programFormsRepository.findAll();
    }

    @Override
    public List<LevelType> getLevelTypes() {
        return levelTypesRepository.findAll();
    }

    @Override
    public List<CompetitionType> getCompetitionTypes() {
        return competitionTypesRepository.findAll();
    }

    @Override
    public List<CompensationType> getCompensationTypes() {
        return compensationTypesRepository.findAll();
    }

    @Override
    public List<ProgramSubject> getProgramSubjects() {
        return programSubjectsRepository.findAll();
    }

    @Override
    public Competition getCompetition(Long competitionId) {
        return competitionsRepository.findOne(competitionId);
    }

    @Override
    @SneakyThrows
    public void competition(CompetitionsForm form) {

        Competition newCompetition = Competition.builder()
                .formativeOrgunit(form.getFormativeOrgunit())
                .competitionType(form.getCompetitionType())
                .programForm(form.getProgramForm())
                .programSubject(form.getProgramSubject())
                .levelType(form.getLevelType())
                .compensationType(form.getCompensationType())
                .programSetOuMinisterialPlan(form.getProgramSetOuMinisterialPlan())
                .programSetOuTargetAdmPlan(form.getProgramSetOuTargetAdmPlan())
                .programSetOuExclusivePlan(form.getProgramSetOuExclusivePlan())
                .programSetOuContractPlan(form.getProgramSetOuContractPlan())
                .build();

        competitionsRepository.save(newCompetition);
    }

}