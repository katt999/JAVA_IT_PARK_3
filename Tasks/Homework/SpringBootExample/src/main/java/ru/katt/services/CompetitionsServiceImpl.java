package ru.katt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.katt.forms.CompetitionsForm;
import ru.katt.models.Competition;
import ru.katt.repositories.CompetitionsRepository;

import java.util.List;

@Service
public class CompetitionsServiceImpl implements CompetitionsService {

  @Autowired
  private CompetitionsRepository competitionsRepository;

  @Override
  public List<Competition> getCompetitions(String orderBy) {
    switch (orderBy) {
      case "id": return competitionsRepository.findByOrderById();
      default: return competitionsRepository.findAll();
    }
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
