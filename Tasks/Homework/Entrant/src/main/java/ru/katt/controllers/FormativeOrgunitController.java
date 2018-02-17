package ru.katt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.katt.forms.FormativeOrgunitsForm;
import ru.katt.models.FormativeOrgunit;
import ru.katt.models.User;
import ru.katt.services.AuthenticationService;
import ru.katt.services.FormativeOrgunitsService;

import java.util.List;

@Controller
public class FormativeOrgunitController {

  @Autowired
  private FormativeOrgunitsService service;

  @Autowired
  private AuthenticationService authenticationService;

  @GetMapping(value = "/formative_orgunits")
  public String getFormativeOrgunits(@ModelAttribute("model")ModelMap model,
                         @RequestParam("order_by") String orderBy,
                         Authentication authentication) {
    List<FormativeOrgunit> formativeOrgunits = service.getFormativeOrgunits(orderBy);
    model.addAttribute("formativeOrgunits", formativeOrgunits);

    User user = authenticationService.getUserByAuthentication(authentication);
    model.addAttribute("user", user);

    return "formative_orgunits_page";
  }

  @PostMapping("/formative_orgunits")
  public String addFormativeOrgunit(@ModelAttribute FormativeOrgunitsForm form,
                               @ModelAttribute("model") ModelMap model,
                               Authentication authentication) {
    service.formativeOrgunit(form);

    User user = authenticationService.getUserByAuthentication(authentication);
    model.addAttribute("user", user);

    return "redirect:/formative_orgunits?order_by=id";
  }

}
