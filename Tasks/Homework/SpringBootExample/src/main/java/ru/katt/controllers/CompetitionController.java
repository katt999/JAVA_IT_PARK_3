package ru.katt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import ru.katt.models.Competition;
import ru.katt.services.CompetitionsService;

import java.util.List;

@Controller
public class CompetitionController {


  @Autowired
  private CompetitionsService service;

  @GetMapping(value = "/competitions")
  public String getCompetitions(@ModelAttribute("model")ModelMap model,
                                     @RequestParam("order_by") String orderBy) {
    List<Competition> competitions = service.getCompetitions(orderBy);
    model.addAttribute("competitions", competitions);
    return "competitions_page";
  }

}
