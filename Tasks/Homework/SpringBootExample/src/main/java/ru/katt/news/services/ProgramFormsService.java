package ru.katt.news.services;

import ru.katt.news.forms.ProgramFormsForm;
import ru.katt.news.models.ProgramForm;

import java.util.List;

public interface ProgramFormsService {
  List<ProgramForm> getProgramForms(String orderBy);

  ProgramForm getProgramForm(Long programFormId);

  void update(Long programFormId, ProgramFormsForm form);
}
