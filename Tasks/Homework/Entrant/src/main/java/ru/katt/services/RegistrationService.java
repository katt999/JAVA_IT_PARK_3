package ru.katt.services;

import ru.katt.forms.RegistrationForm;

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
