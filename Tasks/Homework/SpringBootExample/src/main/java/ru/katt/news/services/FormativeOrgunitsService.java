package ru.katt.news.services;

import ru.katt.news.forms.FormativeOrgunitsForm;
import ru.katt.news.forms.NamesForm;
import ru.katt.news.models.FormativeOrgunit;

import java.util.List;

public interface FormativeOrgunitsService {
  List<FormativeOrgunit> getFormativeOrgunits(String orderBy);

  FormativeOrgunit getFormativeOrgunit (Long formativeOrgunitId);

  void update(Long formativeOrgunitId, FormativeOrgunitsForm form);
}
