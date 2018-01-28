package ru.katt.news.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import ru.katt.news.models.ProgramForm;
import ru.katt.news.services.ProgramFormsService;

import java.util.List;

@Controller
public class ProgramFormController {


  @Autowired
  private ProgramFormsService service;

  @GetMapping(value = "/program_forms")
  public String getProgramForms(@ModelAttribute("model")ModelMap model,
                                     @RequestParam("order_by") String orderBy) {
    List<ProgramForm> programForms = service.getProgramForms(orderBy);
    model.addAttribute("programForms", programForms);
    return "program_forms_page";
  }

}
