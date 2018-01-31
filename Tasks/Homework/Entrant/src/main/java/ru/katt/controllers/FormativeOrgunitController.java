package ru.katt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.katt.models.FormativeOrgunit;
import ru.katt.services.FormativeOrgunitsService;

import java.util.List;

@RestController
public class FormativeOrgunitController {

  @Autowired
  private FormativeOrgunitsService service;

  @GetMapping(value = "/formative_orgunits")
  public String getFormativeOrgunits(@ModelAttribute("model")ModelMap model,
                         @RequestParam("order_by") String orderBy) {
    List<FormativeOrgunit> formativeOrgunits = service.getFormativeOrgunits(orderBy);
    model.addAttribute("formativeOrgunits", formativeOrgunits);
    return "formative_orgunits_page";
  }

}
