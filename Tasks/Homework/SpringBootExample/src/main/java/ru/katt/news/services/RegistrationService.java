package ru.katt.news.services;

import ru.katt.news.forms.RegistrationForm;

public interface RegistrationService {
  /**
   * Принимает на вход данные регистрации
   * Шифрует пароль
   * Сохраняет данные в БД
   * @param form
   * @return email пользователя
   */
  String registration(RegistrationForm form);

  boolean confirm(String confirmString);
}
