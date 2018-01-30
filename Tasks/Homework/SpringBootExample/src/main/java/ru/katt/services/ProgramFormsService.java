package ru.katt.services;

import ru.katt.models.ProgramForm;
import ru.katt.forms.ProgramFormsForm;

import java.util.List;

public interface ProgramFormsService {
  List<ProgramForm> getProgramForms(String orderBy);

  ProgramForm getProgramForm(Long programFormId);

  void update(Long programFormId, ProgramFormsForm form);
}
