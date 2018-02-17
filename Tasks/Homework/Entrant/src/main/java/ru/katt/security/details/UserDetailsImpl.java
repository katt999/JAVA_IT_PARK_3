package ru.katt.security.details;

/**
 * Created by user on 02.02.2018.
 */
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.katt.models.State;
import ru.katt.models.User;

import java.util.Collection;
import java.util.Collections;

public class UserDetailsImpl implements UserDetails{

    private User user;

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().name());
        return Collections.singleton(authority);
    }

    @Override
    public String getPassword() {
        return user.getHashPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !user.getState().equals(State.BANNED);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !user.getState().equals(State.NOT_CONFIRMED);
    }

    @Override
    public boolean isEnabled() {
        return !user.getState().equals(State.DELETED);
    }
}