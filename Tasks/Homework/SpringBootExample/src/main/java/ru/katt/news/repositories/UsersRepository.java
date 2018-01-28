package ru.katt.news.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.katt.news.models.User;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
  List<User> findByOrderByRegistrationTimeDesc();
  List<User> findByOrderById();
  List<User> findByOrderByName();

  Optional<User> findByConfirmCode(String confirmCode);
}
