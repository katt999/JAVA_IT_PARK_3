package ru.katt.controllers;

/**
 * Created by EVZabinskaya on 31.01.2018.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.katt.forms.CompetitionsForm;
import ru.katt.models.*;
import ru.katt.services.AuthenticationService;
import ru.katt.services.CompetitionsService;

import java.util.List;

@Controller
public class CompetitionController {

    @Autowired
    private CompetitionsService service;

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/competitions")
    public String getCompetitions(@ModelAttribute("model")ModelMap model,
                                  @RequestParam("order_by") String orderBy,
                                  Authentication authentication) {
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

        User user = authenticationService.getUserByAuthentication(authentication);
        model.addAttribute("user", user);

        return "competitions_page";
    }


    @PostMapping("/competitions")
    public String addCompetition(@ModelAttribute CompetitionsForm form,
                                   @ModelAttribute("model") ModelMap model,
                                   Authentication authentication) {
        service.competition(form);

        User user = authenticationService.getUserByAuthentication(authentication);
        model.addAttribute("user", user);

        return "redirect:/competitions?order_by=id";
    }

    @GetMapping("/competitions/{competition-id}")
    public String getCompetitionPage(@ModelAttribute("model") ModelMap model,
                              @PathVariable("competition-id") Long competitionId,
                              Authentication authentication) {
        Competition competition = service.getCompetition(competitionId);
        List<FormativeOrgunit> formativeOrgunits = service.getFormativeOrgunits();
        List<ProgramForm> programForms = service.getProgramForms();
        List<LevelType> levelTypes = service.getLevelTypes();
        List<CompetitionType> competitionTypes = service.getCompetitionTypes();
        List<CompensationType> compensationTypes = service.getCompensationTypes();
        List<ProgramSubject> programSubjects = service.getProgramSubjects();
        model.addAttribute("competition", competition);
        model.addAttribute("formativeOrgunits", formativeOrgunits);
        model.addAttribute("programForms", programForms);
        model.addAttribute("levelTypes", levelTypes);
        model.addAttribute("competitionTypes", competitionTypes);
        model.addAttribute("compensationTypes", compensationTypes);
        model.addAttribute("programSubjects", programSubjects);

        User user = authenticationService.getUserByAuthentication(authentication);
        model.addAttribute("user", user);

        return "competition_page";
    }
}