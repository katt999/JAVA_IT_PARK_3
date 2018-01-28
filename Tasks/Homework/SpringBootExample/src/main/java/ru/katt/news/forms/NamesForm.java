package ru.katt.news.forms;

import lombok.*;
import lombok.Data;
import ru.katt.news.models.User;

@Data
public class NamesForm {
  private String name;
  private String surname;

  public void update(User user) {
    user.setName(this.name);
    user.setSurname(this.surname);
  }

}
