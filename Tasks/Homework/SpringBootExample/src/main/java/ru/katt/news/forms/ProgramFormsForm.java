package ru.katt.news.forms;

import lombok.Data;
import ru.katt.news.models.FormativeOrgunit;
import ru.katt.news.models.ProgramForm;

@Data
public class ProgramFormsForm {
  private String title;

  public void update(ProgramForm programForm) {
    programForm.setTitle(this.title);
  }

}
