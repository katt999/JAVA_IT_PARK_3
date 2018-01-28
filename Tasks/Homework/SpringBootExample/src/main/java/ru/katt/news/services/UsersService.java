package ru.katt.news.services;

import ru.katt.news.forms.NamesForm;
import ru.katt.news.models.User;

import java.util.List;

public interface UsersService {
  List<User> getUsers(String orderBy);

  User getUser(Long userId);

  void update(Long userId, NamesForm form);
}
