package ru.katt.services;

import ru.katt.forms.EntrantsForm;
import ru.katt.models.*;

import java.util.List;

/**
 * Created by user on 06.02.2018.
 */
public interface EntrantsService {

    List<Entrant> getEntrants(String orderBy);

    List<FormativeOrgunit> getFormativeOrgunits();
    List<ProgramForm> getProgramForms();
    List<LevelType> getLevelTypes();
    List<CompensationType> getCompensationTypes();
    List<ProgramSubject> getProgramSubjects();

    Entrant getEntrant(Long entrantId);

    Entrant findByIdAndEmail(Long EntrantId,String email);


    List<Entrant> getListEntrantListWithParameters(long parameter1,long parameter2,long parameter3,long parameter4,long parameter5);

    void entrant(EntrantsForm form);

    List<Integer> findPosition(Long entrantId);

}
