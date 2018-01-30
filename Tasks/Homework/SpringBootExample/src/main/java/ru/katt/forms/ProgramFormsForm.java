package ru.katt.forms;

import lombok.Data;
import ru.katt.models.ProgramForm;

@Data
public class ProgramFormsForm {
  private String title;

  public void update(ProgramForm programForm) {
    programForm.setTitle(this.title);
  }

}
