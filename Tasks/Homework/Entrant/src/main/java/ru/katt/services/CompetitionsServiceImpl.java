package ru.katt.services;

/**
 * Created by EVZabinskaya on 31.01.2018.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.katt.forms.CompetitionsForm;
import ru.katt.models.Competition;
import ru.katt.models.FormativeOrgunit;
import ru.katt.repositories.CompetitionsRepository;
import ru.katt.repositories.FormativeOrgunitsRepository;

import java.util.List;

@Service
public class CompetitionsServiceImpl implements CompetitionsService {

    @Autowired
    private CompetitionsRepository competitionsRepository;

    @Autowired
    private FormativeOrgunitsRepository formativeOrgunitsRepository;

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
    public Competition getCompetition(Long competitionId) {
        return competitionsRepository.findOne(competitionId);
    }

    @Override
    public void update(Long competitionId, CompetitionsForm form) {
        Competition competition = competitionsRepository.findOne(competitionId);
        form.update(competition);
        competitionsRepository.save(competition);
    }
}