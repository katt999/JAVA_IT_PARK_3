package ru.katt.forms;

import lombok.Data;
import ru.katt.models.FormativeOrgunit;

@Data
public class FormativeOrgunitsForm {
  private String shortTitle;
  private String fullTitle;

  public void update(FormativeOrgunit formativeOrgunit) {
    formativeOrgunit.setShortTitle(this.shortTitle);
    formativeOrgunit.setFullTitle(this.fullTitle);
  }

}
