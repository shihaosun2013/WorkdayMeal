package com.workdaymeals.module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.workdaymeals.config.WorkdayMealsConfig;
import com.workdaymeals.persistence.UserDao;
import com.workdaymeals.resources.rest.GuestResource;
import com.workdaymeals.resources.rest.UserResource;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Environment;
import lombok.extern.slf4j.Slf4j;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

@Slf4j
public class WorkdayMealsModule extends AbstractModule {

    private final WorkdayMealsConfig config;
    private final Environment environment;

    public WorkdayMealsModule(WorkdayMealsConfig config, Environment environment) {
        this.config = config;
        this.environment = environment;
    }

    @Override
    protected void configure() {
        bind(UserResource.class).in(Singleton.class);
        bind(GuestResource.class).in(Singleton.class);
    }

    @Provides
    @Singleton
    @Named("jdbi")
    public Jdbi getJdbi() {
        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, config.getDataSourceFactory(), "mysql");
        jdbi.installPlugin(new SqlObjectPlugin());
        return jdbi;
    }

    @Provides
    @Singleton
    public UserDao getUserDao(@Named("jdbi") Jdbi jdbi) {
        return jdbi.onDemand(UserDao.class);
    }
}
