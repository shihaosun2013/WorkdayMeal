package com.workdaymeals.auth;

import com.google.common.cache.CacheBuilderSpec;
import com.workdaymeals.model.User;
import io.dropwizard.auth.Authorizer;
import io.dropwizard.auth.CachingAuthenticator;
import io.dropwizard.auth.basic.BasicCredentials;

public class ExampleAuthorizer implements Authorizer<User> {
    @Override
    public boolean authorize(User user, String role) {

//        CacheBuilderSpec cacheBuilderSpec =
       /* ExampleAuthenticator simpleAuthenticator = new ExampleAuthenticator();
        CachingAuthenticator<BasicCredentials, User> cachingAuthenticator = new CachingAuthenticator<>(
                metricRegistry, simpleAuthenticator,
                config.getAuthenticationCachePolicy());*/

        return user.getFirstName().equals("good-guy") && role.equals("ADMIN");
    }
}