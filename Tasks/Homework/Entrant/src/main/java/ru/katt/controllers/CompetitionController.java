package ru.katt.controllers;

/**
 * Created by EVZabinskaya on 31.01.2018.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import ru.katt.models.*;
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
        List<FormativeOrgunit> formativeOrgunits = service.getFormativeOrgunits();
        List<ProgramForm> programForms = service.getProgramForms();
        List<LevelType> levelTypes = service.getLevelTypes();
        List<CompetitionType> competitionTypes = service.getCompetitionTypes();
        List<CompensationType> compensationTypes = service.getCompensationTypes();
        List<ProgramSubject> programSubjects = service.getProgramSubjects();
        model.addAttribute("competitions", competitions);
        model.addAttribute("formativeOrgunits", formativeOrgunits);
        model.addAttribute("programForms", programForms);
        model.addAttribute("levelTypes", levelTypes);
        model.addAttribute("competitionTypes", competitionTypes);
        model.addAttribute("compensationTypes", compensationTypes);
        model.addAttribute("programSubjects", programSubjects);
        return "competitions_page";
    }

}