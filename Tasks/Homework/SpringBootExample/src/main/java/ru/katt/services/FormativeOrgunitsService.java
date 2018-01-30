package ru.katt.services;

import ru.katt.forms.FormativeOrgunitsForm;
import ru.katt.models.FormativeOrgunit;

import java.util.List;

public interface FormativeOrgunitsService {
  List<FormativeOrgunit> getFormativeOrgunits(String orderBy);

  FormativeOrgunit getFormativeOrgunit (Long formativeOrgunitId);

  void update(Long formativeOrgunitId, FormativeOrgunitsForm form);
}
