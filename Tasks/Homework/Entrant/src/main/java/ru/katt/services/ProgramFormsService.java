package ru.katt.services;

import ru.katt.forms.ProgramFormsForm;
import ru.katt.models.ProgramForm;

import java.util.List;

public interface ProgramFormsService {
  List<ProgramForm> getProgramForms(String orderBy);

  ProgramForm getProgramForm(Long programFormId);

  void update(Long programFormId, ProgramFormsForm form);

  void programForm(ProgramFormsForm form);
}
