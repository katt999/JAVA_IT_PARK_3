package ru.katt.forms;

import lombok.Data;
import lombok.ToString;
import ru.katt.models.Competition;
import ru.katt.models.ExamEntrant;

import java.util.List;

/**
 * Created by user on 06.02.2018.
 */

@Data
@ToString
public class EntrantsForm {
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String citizenship;
    private String eduDocumentNumber;
    private String email;
    private List<Competition> competitions;
    private List<ExamEntrant> examEntrants;
}
