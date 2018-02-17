package ru.katt.forms;

import lombok.Data;
import ru.katt.models.User;

@Data
public class ListEntrantParameterForm {
    private Long formativeOrgunit;
    private Long programForm;
    private Long levelType;
    private Long compensationType;
    private Long programSubject;

}

