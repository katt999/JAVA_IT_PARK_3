package ru.katt.services;

import ru.katt.forms.NamesForm;
import ru.katt.models.User;

import java.util.List;

public interface UsersService {
  List<User> getUsers(String orderBy);

  User getUser(Long userId);

  void update(Long userId, NamesForm form);
}
