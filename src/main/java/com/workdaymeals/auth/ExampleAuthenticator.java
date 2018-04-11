package com.workdaymeals.auth;

import com.workdaymeals.model.User;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

import java.util.Optional;

public class ExampleAuthenticator implements Authenticator<BasicCredentials, User> {
    @Override
    public Optional<User> authenticate(BasicCredentials credentials) throws AuthenticationException {
        if ("crimson".equals(credentials.getPassword())) {
            return Optional.of(User.builder().firstName("shihao").build());
        } else {
            return Optional.empty();
        }
    }
}