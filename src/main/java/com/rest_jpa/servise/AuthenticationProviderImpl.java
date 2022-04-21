package com.rest_jpa.servise;

import com.rest_jpa.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthenticationProviderImpl implements AuthenticationProvider{

    private UserRepository userRepository;

    @Override
    public Optional<Authentication> getAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return isValid(authentication) ? Optional.of(authentication) : Optional.empty();
    }

    @Override
    public Optional<User> getUserDetails() {
        return getAuthentication().map(auth -> (User) auth.getPrincipal());
    }

    @Override
    public Optional<com.rest_jpa.entity.User> getUser() {
        return getUserDetails().flatMap(userDetails -> {
            Optional<com.rest_jpa.entity.User> user = userRepository.findByLogonName(userDetails.getUsername());
            return user;
        });
    }

    private boolean isValid(Authentication authentication) {
        return authentication != null
                && authentication.isAuthenticated()
                && !(authentication.getPrincipal() instanceof String);
    }
}
