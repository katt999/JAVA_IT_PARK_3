package ru.katt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.katt.models.User;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
  List<User> findByOrderByRegistrationTimeDesc();
  List<User> findByOrderById();
  List<User> findByOrderByName();

  Optional<User> findByConfirmCode(String confirmCode);
}
