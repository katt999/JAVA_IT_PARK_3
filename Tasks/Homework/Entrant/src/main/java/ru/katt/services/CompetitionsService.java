package ru.katt.services;

/**
 * Created by EVZabinskaya on 31.01.2018.
 */
import ru.katt.forms.CompetitionsForm;
import ru.katt.models.*;

import java.util.List;

/**
 * Created by user on 30.01.2018.
 */
public interface CompetitionsService {
    List<Competition> getCompetitions(String orderBy);

    List<FormativeOrgunit> getFormativeOrgunits();
    List<ProgramForm> getProgramForms();
    List<LevelType> getLevelTypes();
    List<CompetitionType> getCompetitionTypes();
    List<CompensationType> getCompensationTypes();
    List<ProgramSubject> getProgramSubjects();

    Competition getCompetition(Long CompetitionId);

    void competition(CompetitionsForm form);
}