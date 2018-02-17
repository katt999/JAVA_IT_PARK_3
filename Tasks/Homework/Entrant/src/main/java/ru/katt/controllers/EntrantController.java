package ru.katt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.katt.dto.EntrantDto;
import ru.katt.dto.ExamEntrantDto;
import ru.katt.forms.EntrantsForm;
import ru.katt.forms.ListEntrantParameterForm;
import ru.katt.models.*;
import ru.katt.repositories.CompetitionsRepository;
import ru.katt.repositories.EntrantsRepository;
import ru.katt.services.AuthenticationService;
import ru.katt.services.EntrantsService;

import java.util.List;

@Controller
public class EntrantController {

  @Autowired
  private EntrantsService service;

  @Autowired
  private EntrantsRepository repository;

  @Autowired
  private AuthenticationService authenticationService;

  @GetMapping(value = "/entrants")
  public String getEntrants(@ModelAttribute("model")ModelMap model,
                            @RequestParam("order_by") String orderBy,
                            Authentication authentication) {
    List<Entrant> entrants = service.getEntrants(orderBy);
   // System.out.println(repository.query("Екатерина"));
    model.addAttribute("entrants", entrants);

    User user = authenticationService.getUserByAuthentication(authentication);
    model.addAttribute("user", user);

    return "entrants_page";
  }

  @PostMapping("/entrants")
  public String addEntrant(@ModelAttribute EntrantsForm form,
                            @ModelAttribute("model") ModelMap model,
                            Authentication authentication) {
    service.entrant(form);

      User user = authenticationService.getUserByAuthentication(authentication);
      model.addAttribute("user", user);

    return "redirect:/entrants?order_by=id";
  }

  @GetMapping("/list_entrant")
  public String getAttributeListEntrant(@ModelAttribute("model") ModelMap model,
                                        Authentication authentication) {
    List<FormativeOrgunit> formativeOrgunits = service.getFormativeOrgunits();
    List<ProgramForm> programForms = service.getProgramForms();
    List<LevelType> levelTypes = service.getLevelTypes();
    List<CompensationType> compensationTypes = service.getCompensationTypes();
    List<ProgramSubject> programSubjects = service.getProgramSubjects();
    model.addAttribute("formativeOrgunits", formativeOrgunits);
    model.addAttribute("programForms", programForms);
    model.addAttribute("levelTypes", levelTypes);
    model.addAttribute("compensationTypes", compensationTypes);
    model.addAttribute("programSubjects", programSubjects);
   // System.out.println(repository.findListEntrant(1,1,1,1,1));
    List<Entrant> entrants = service.getEntrants("order_by=id");
    model.addAttribute("entrants", entrants);

    User user = authenticationService.getUserByAuthentication(authentication);
    model.addAttribute("user", user);

      return "list_entrant";
  }

  @PostMapping("/list_entrant")
  @ResponseBody
  public ResponseEntity<Object>  getListEntrant(@RequestParam(required=false,name="formativeOrgunit") Long formativeOrgunit,
                        @RequestParam(required=false,name="programForm") Long programForm,
                        @RequestParam(required=false,name="levelType") Long levelType,
                        @RequestParam(required=false,name="compensationType") Long compensationType,
                        @RequestParam(required=false,name="programSubject") Long programSubject,
                        @ModelAttribute("model") ModelMap model,
                        Authentication authentication){
      List<Entrant> entrants =  service.getListEntrantListWithParameters(formativeOrgunit, programForm, compensationType, levelType, programSubject);
      List<EntrantDto> result = EntrantDto.from(entrants);

      User user = authenticationService.getUserByAuthentication(authentication);
      model.addAttribute("user", user);

      return ResponseEntity.ok(result);
  }

    @GetMapping(value = "/rating")
    public String getRating(@ModelAttribute("model")ModelMap model,
                            Authentication authentication) {
        User user = authenticationService.getUserByAuthentication(authentication);
        model.addAttribute("user", user);
        return "rating";
    }

    @PostMapping("/rating")
    public String viewRating(@RequestParam(required=false,name="application") Long application,
                             @ModelAttribute("model") ModelMap model,
                             Authentication authentication) {

        User user = authenticationService.getUserByAuthentication(authentication);
        Entrant entrant = service.findByIdAndEmail(application, user.getEmail());
        List<Integer> positions = service.findPosition(application);
     // System.out.println("position: " + service.findPosition(application));

        model.addAttribute("user", user);
        model.addAttribute("entrant", entrant);
        model.addAttribute("positions", positions);
        return "view_rating";
    }


}
