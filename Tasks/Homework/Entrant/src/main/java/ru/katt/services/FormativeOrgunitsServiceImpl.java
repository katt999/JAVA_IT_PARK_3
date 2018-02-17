package ru.katt.services;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.katt.forms.FormativeOrgunitsForm;
import ru.katt.models.FormativeOrgunit;
import ru.katt.repositories.FormativeOrgunitsRepository;

import java.util.List;

@Service
public class FormativeOrgunitsServiceImpl implements FormativeOrgunitsService {

  @Autowired
  private FormativeOrgunitsRepository formativeOrgunitsRepository;

  @Override
  public List<FormativeOrgunit> getFormativeOrgunits(String orderBy) {
    switch (orderBy) {
    //  case "registration_date": return usersRepository.findByOrderByRegistrationTimeDesc();
      case "id": return formativeOrgunitsRepository.findByOrderById();
      case "shortTitle": return formativeOrgunitsRepository.findByOrderByShortTitle();
      case "fullTitle": return formativeOrgunitsRepository.findByOrderByFullTitle();
      default: return formativeOrgunitsRepository.findAll();
    }
   // return formativeOrgunitsRepository.findAll();
  }

  @Override
  public FormativeOrgunit getFormativeOrgunit(Long formativeOrgunitId) {
    return formativeOrgunitsRepository.findOne(formativeOrgunitId);
  }

  @Override
  public void update(Long formativeOrgunitId, FormativeOrgunitsForm form) {
    FormativeOrgunit formativeOrgunit = formativeOrgunitsRepository.findOne(formativeOrgunitId);
    form.update(formativeOrgunit);
    formativeOrgunitsRepository.save(formativeOrgunit);
  }

  @Override
  @SneakyThrows
  public void formativeOrgunit(FormativeOrgunitsForm form) {

    FormativeOrgunit newFormativeOrgunit = FormativeOrgunit.builder()
            .shortTitle(form.getShortTitle())
            .fullTitle(form.getFullTitle())
            .build();

    formativeOrgunitsRepository.save(newFormativeOrgunit);
  }
}
