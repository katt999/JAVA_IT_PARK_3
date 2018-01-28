package ru.katt.news.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.katt.news.forms.ProgramFormsForm;
import ru.katt.news.models.ProgramForm;
import ru.katt.news.repositories.ProgramFormsRepository;

import java.util.List;

@Service
public class ProgramFormsServiceImpl implements ProgramFormsService {

  @Autowired
  private ProgramFormsRepository programFormsRepository;

  @Override
  public List<ProgramForm> getProgramForms(String orderBy) {
    switch (orderBy) {
      case "id": return programFormsRepository.findByOrderById();
      default: return programFormsRepository.findAll();
    }
  }

  @Override
  public ProgramForm getProgramForm(Long programFormId) {
    return programFormsRepository.findOne(programFormId);
  }

  @Override
  public void update(Long programFormId, ProgramFormsForm form) {
    ProgramForm programForm = programFormsRepository.findOne(programFormId);
    form.update(programForm);
    programFormsRepository.save(programForm);
  }
}
