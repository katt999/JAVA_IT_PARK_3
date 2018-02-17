package ru.katt.services;

/**
 * Created by user on 02.02.2018.
 */
import org.springframework.security.core.Authentication;
import ru.katt.models.User;

public interface AuthenticationService {
    User getUserByAuthentication(Authentication authentication);
}
