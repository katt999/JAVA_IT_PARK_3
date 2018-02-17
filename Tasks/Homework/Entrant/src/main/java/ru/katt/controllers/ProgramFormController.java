package ru.katt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.katt.forms.ProgramFormsForm;
import ru.katt.models.ProgramForm;
import ru.katt.models.User;
import ru.katt.services.AuthenticationService;
import ru.katt.services.ProgramFormsService;

import java.util.List;

@Controller
public class ProgramFormController {

  @Autowired
  private ProgramFormsService service;

  @Autowired
  private AuthenticationService authenticationService;

  @GetMapping(value = "/program_forms")
  public String getProgramForms(@ModelAttribute("model")ModelMap model,
                                     @RequestParam("order_by") String orderBy,
                                     Authentication authentication) {
    List<ProgramForm> programForms = service.getProgramForms(orderBy);
    model.addAttribute("programForms", programForms);

    User user = authenticationService.getUserByAuthentication(authentication);
    model.addAttribute("user", user);

    return "program_forms_page";
  }

  @PostMapping("/program_forms")
  public String addProgramForm(@ModelAttribute ProgramFormsForm form,
                               @ModelAttribute("model") ModelMap model,
                               Authentication authentication) {
    service.programForm(form);

    User user = authenticationService.getUserByAuthentication(authentication);
    model.addAttribute("user", user);

    return "redirect:/program_forms?order_by=id";
  }

}
