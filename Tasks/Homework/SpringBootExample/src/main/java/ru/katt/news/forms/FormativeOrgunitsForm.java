package ru.katt.news.forms;

import lombok.Data;
import ru.katt.news.models.FormativeOrgunit;

@Data
public class FormativeOrgunitsForm {
  private String shortTitle;
  private String fullTitle;

  public void update(FormativeOrgunit formativeOrgunit) {
    formativeOrgunit.setShortTitle(this.shortTitle);
    formativeOrgunit.setFullTitle(this.fullTitle);
  }

}
