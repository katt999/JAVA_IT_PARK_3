package ru.katt.services;

/**
 * Created by EVZabinskaya on 31.01.2018.
 */
import ru.katt.forms.CompetitionsForm;
import ru.katt.models.Competition;
import ru.katt.models.FormativeOrgunit;
import ru.katt.repositories.FormativeOrgunitsRepository;

import java.util.List;

/**
 * Created by user on 30.01.2018.
 */
public interface CompetitionsService {
    List<Competition> getCompetitions(String orderBy);

    List<FormativeOrgunit> getFormativeOrgunits();

    Competition getCompetition(Long CompetitionId);

    void update(Long competitionId, CompetitionsForm form);
}