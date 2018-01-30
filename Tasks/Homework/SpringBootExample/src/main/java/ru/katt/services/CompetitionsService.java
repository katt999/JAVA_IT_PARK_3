package ru.katt.services;

import ru.katt.forms.CompetitionsForm;
import ru.katt.models.Competition;

import java.util.List;

/**
 * Created by user on 30.01.2018.
 */
public interface CompetitionsService {
    List<Competition> getCompetitions(String orderBy);

    Competition getCompetition (Long CompetitionId);

    void update(Long competitionId, CompetitionsForm form);
}
